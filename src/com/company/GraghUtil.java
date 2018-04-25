package com.company;

import java.util.List;

public class GraghUtil {

    public static void deepFirstSearchWithMaxStops(DirectedGragh gragh, String endStr, String path, int maxStops, Result result) {
        if (path.length() > maxStops + 1) {
            return;
        }
        if (path.length() > 1 && path.endsWith(endStr)) {
            result.setResultCount(result.getResultCount() + 1);
//            System.out.println(path);
            return;
        }
        int lastVertexIndex = getIndexByChar(path.charAt(path.length() - 1));
        int[][] edges = gragh.getEdges();
        if (edges == null) return;
        for (int i = 0; i < edges[lastVertexIndex].length; i++) {
            if (edges[lastVertexIndex][i] > 0) {
                String newPath = path + getCharByIndex(i);
                deepFirstSearchWithMaxStops(gragh, endStr, newPath, maxStops, result);
            }
        }
    }

    public static void deepFirstSearchWithStops(DirectedGragh gragh, String endStr, String path, int exactlyStops, Result result) {
        if (path.length() == exactlyStops + 1) {
            if (path.length() > 1 && path.endsWith(endStr)) {
                result.setResultCount(result.getResultCount() + 1);
//                System.out.println(path);
            }
            return;
        }
        int lastVertexIndex = getIndexByChar(path.charAt(path.length() - 1));
        int[][] edges = gragh.getEdges();
        if (edges == null) return;
        for (int i = 0; i < edges[lastVertexIndex].length; i++) {
            if (edges[lastVertexIndex][i] > 0) {
                String newPath = path + getCharByIndex(i);
                deepFirstSearchWithStops(gragh, endStr, newPath, exactlyStops, result);
            }
        }
    }

    public static void findShortestPath(DirectedGragh gragh, String endStr, String path, int cost, Result result) {
        if (path.endsWith(endStr) && cost < result.resultCount && cost > 0) {
            result.resultCount = cost;
//            System.out.println("best path:" + path);
            return;
        }
        int lastVertexIndex = getIndexByChar(path.charAt(path.length() - 1));
        int[][] edges = gragh.getEdges();
        if (edges == null) return;
        for (int i = 0; i < edges[lastVertexIndex].length; i++) {
            if (edges[lastVertexIndex][i] > 0) {
                char newChar = GraghUtil.getCharByIndex(i);
                if (path.indexOf(newChar) > 0) {
                    continue;
                }
                int newCost = edges[lastVertexIndex][i];
                String newPath = path + getCharByIndex(i);
                findShortestPath(gragh, endStr, newPath, cost + newCost, result);
            }
        }
    }

    public static void findPathWithExactlyCost(DirectedGragh gragh, String endStr, String path, int cost, int exactlyCost, List<String> result) {
        if (cost >= exactlyCost) {
            return;
        }
        if (path.endsWith(endStr) && cost > 0) {
            result.add(path);
        }
        int lastVertexIndex = getIndexByChar(path.charAt(path.length() - 1));
        int[][] edges = gragh.getEdges();
        if (edges == null) return;
        for (int i = 0; i < edges[lastVertexIndex].length; i++) {
            if (edges[lastVertexIndex][i] > 0) {
                int newCost = edges[lastVertexIndex][i];
                String newPath = path + getCharByIndex(i);
                findPathWithExactlyCost(gragh, endStr, newPath, cost + newCost, exactlyCost, result);
            }
        }
    }

    public static int getIndexByChar(char vertexChar) {
        return vertexChar - 'A';
    }

    public static char getCharByIndex(int index) {
        return (char)('A' + index);
    }

    public static int getDistanceByPath(String path, DirectedGragh gragh) {
        int pathLength = path.length();
        if (pathLength <= 1) {
            return 0;
        }
        int distance = 0;
        for (int i = 1; i < pathLength; i++) {
            char charFirst = path.charAt(i - 1);
            char charSecond = path.charAt(i);
            int indexFirst = GraghUtil.getIndexByChar(charFirst);
            int indexSecond = GraghUtil.getIndexByChar(charSecond);
            int weight = gragh.getWeight(indexFirst, indexSecond);
            if (weight == 0) {
                distance = 0;
                break;
            }
            distance += weight;
        }
        return distance;
    }

}
