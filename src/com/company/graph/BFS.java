package com.company.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }

    private static class Graph {
        private final int[][] graphArray;
        private final int[] graphVisitedArray;
        private Queue<Integer> graphQueue = new PriorityQueue<>();

        public Graph(int i) {
            graphArray = new int[i][i];
            graphVisitedArray = new int[i];
        }

        public void addEdge(int i, int j) {
            graphArray[i][j] = 1;
        }

        public void BFS(int i) {
            BFSHelper(i);
        }

        private void BFSHelper(int i) {
            graphQueue.add(i);
            Integer node;
            while ((node = graphQueue.poll()) != null) {
                visited(node);
                graphQueue.addAll(getChilds(node));
            }
        }

        private void visited(int i) {
            graphVisitedArray[i] = 1;
        }

        private List<Integer> getChilds(int i) {
            List<Integer> listHelper = new ArrayList<>();
            for (int j = 0; j < this.graphArray.length; j++) {
                if (graphArray[i][j] != 0 && graphVisitedArray[j] == 0)
                    listHelper.add(j);
            }
            return listHelper;
        }
    }
}
