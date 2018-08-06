package com.company.graph;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS(2);
    }

    private static class Graph {
        private final int[][] graphArray;
        private final int[] graphVisitedArray;
        private Queue<Integer> graphQueue = new PriorityQueue<>();

        public Graph(int i) {
            graphArray = new int[i][i];
            Arrays.stream(graphArray).forEach(line -> Arrays.stream(line).forEach(cell -> cell = -1));

            graphVisitedArray = new int[i];
            Arrays.stream(graphVisitedArray).forEach(cell -> cell = -1);
        }

        public void addEdge(int i, int j) {
            graphArray[i][j] = 1;
        }

        public void DFS(int i) {
            List<Integer> listHelper = new ArrayList<>();
            BFSHelper(i, listHelper);
        }

        private void BFSHelper(int i, List<Integer> listHelper) {
            listHelper.add(i);
            System.out.println("Added child: " + i);
            visited(i);

//            get node i childs
            List<Integer> childs = getChilds(i);

            graphQueue.addAll(childs);
            for (int j = 0; j < childs.size(); j++) {
                BFSHelper(childs.get(j), listHelper);
            }
        }

        private void visited(int i) {
            graphVisitedArray[i] = 1;
        }

        private List<Integer> getChilds(int i) {
            List<Integer> listHelper = new ArrayList<>();
            for (int j = 0; j < this.graphArray.length; j++) {
                if (graphArray[i][j] != -1 && graphVisitedArray[j] == -1)
                    listHelper.add(j);
            }
            return listHelper;
        }
    }
}
