package com.company;

import java.util.ArrayList;

public class DirectedGragh {

    private ArrayList vertexList;

    private int[][] edges;

    private int numOfEdge;

    public DirectedGragh(int n) {
        vertexList = new ArrayList(n);
        edges = new int[n][n];
        numOfEdge = 0;
    }

    public int[][] getEdges() {
        return edges;
    }

    public int getVertexCount() {
        return vertexList.size();
    }

    public int getEgesCount() {
        return numOfEdge;
    }

    public Object getVertexValue(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertObject(Object vertext) {
        vertexList.add(vertext);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdge ++;
    }

    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdge --;
    }

    /**
     * get first neighbor of vertex
     * @param vertexIndex
     * @return
     */
    public int getFirstNeighbor(int vertexIndex) {
        for (int i = 0; i < vertexList.size(); i ++) {
            if (edges[vertexIndex][i] > 0) {
                return i;
            }
        }
        return -1;
    }

}
