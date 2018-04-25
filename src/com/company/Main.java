package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DirectedGragh directedGragh = new DirectedGragh(5);
        input(directedGragh);
        output1(directedGragh);
        output2(directedGragh);
        output3(directedGragh);
        output4(directedGragh);
        output5(directedGragh);
        output6(directedGragh);
        output7(directedGragh);
        output8(directedGragh);
        output9(directedGragh);
        output10(directedGragh);
    }

    public static void output1(DirectedGragh gragh) {
        int distance = GraghUtil.getDistanceByPath("ABC", gragh);
        if (distance > 0) {
            System.out.println("Output #1:" + distance);
        } else {
            System.out.println("Output #1:NO SUCH ROUTE");
        }

    }

    public static void output2(DirectedGragh gragh) {
        int distance = GraghUtil.getDistanceByPath("AD", gragh);
        if (distance > 0) {
            System.out.println("Output #2:" + distance);
        } else {
            System.out.println("Output #2:NO SUCH ROUTE");
        }
    }

    public static void output3(DirectedGragh gragh) {
        int distance = GraghUtil.getDistanceByPath("ADC", gragh);
        if (distance > 0) {
            System.out.println("Output #3:" + distance);
        } else {
            System.out.println("Output #3:NO SUCH ROUTE");
        }
    }

    public static void output4(DirectedGragh gragh) {
        int distance = GraghUtil.getDistanceByPath("AEBCD", gragh);
        if (distance > 0) {
            System.out.println("Output #4:" + distance);
        } else {
            System.out.println("Output #4:NO SUCH ROUTE");
        }
    }

    public static void output5(DirectedGragh gragh) {
        int distance = GraghUtil.getDistanceByPath("AED", gragh);
        if (distance > 0) {
            System.out.println("Output #5:" + distance);
        } else {
            System.out.println("Output #5:NO SUCH ROUTE");
        }
    }

    public static void output6(DirectedGragh gragh) {
        Result result = new Result();
        GraghUtil.deepFirstSearchWithMaxStops(gragh, "C", "C", 3, result);
        System.out.println("Output #6:" + result.resultCount);
    }

    public static void output7(DirectedGragh gragh) {
        Result result = new Result();
        GraghUtil.deepFirstSearchWithStops(gragh, "C", "A", 4, result);
        System.out.println("Output #7:" + result.resultCount);
    }

    public static void output8(DirectedGragh gragh) {
        Result result = new Result();
        result.resultCount = Integer.MAX_VALUE;
        GraghUtil.findShortestPath(gragh, "C", "A", 0, result);
        System.out.println("Output #8:" + result.resultCount);
    }

    public static void output9(DirectedGragh gragh) {
        Result result = new Result();
        result.resultCount = Integer.MAX_VALUE;
        GraghUtil.findShortestPath(gragh, "B", "B", 0, result);
        System.out.println("Output #9:" + result.resultCount);
    }

    public static void output10(DirectedGragh gragh) {
        List<String> result = new ArrayList<>();
        GraghUtil.findPathWithExactlyCost(gragh, "C", "C", 0,30, result);
        System.out.println("Output #10:" + result.size());
    }

    // Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
    public static void input(DirectedGragh  gragh) {
        gragh.insertObject("A"); // A index:0
        gragh.insertObject("B"); // B index:1
        gragh.insertObject("C"); // C index:2
        gragh.insertObject("D"); // D index:3
        gragh.insertObject("E"); // E index:4

        gragh.insertEdge(0, 1 , 5);
        gragh.insertEdge(1, 2 , 4);
        gragh.insertEdge(2, 3 , 8);
        gragh.insertEdge(3, 2 , 8);
        gragh.insertEdge(3, 4    , 6);
        gragh.insertEdge(0, 3    , 5);
        gragh.insertEdge(2, 4    , 2);
        gragh.insertEdge(4, 1    , 3);
        gragh.insertEdge(0, 4    , 7);
    }

}
