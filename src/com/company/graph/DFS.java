package com.company.graph;


import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
//
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        g.DFS(2);
    }

    private static class Graph {
        private int[][] graphArray;
        private int[] graphVisitedArray;

        public Graph(int i) {
            graphArray = new int[i][i];
            graphVisitedArray = new int[i];
        }

        public void addEdge(int i, int j) {
            graphArray[i][j] = 1;
        }

        public void DFS(int i) {
            List<Integer> listHelper = new ArrayList<>();
            DFSHelper(i, listHelper);
        }

        private void DFSHelper(int i, List<Integer> listHelper) {
            System.out.println("Added child: " + i);
            listHelper.add(i);
            visited(i);

            getChilds(i).stream().forEach(child -> DFSHelper(child, listHelper));
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
