package com.company.graph;


import java.util.ArrayList;
import java.util.List;

public class BFS {

    public static void main(String[] args) {
        // write your code here

        Graph g = new Graph(4);
//
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
//
        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
        g.BFS(2);
    }

    private static class Graph {
        private int[][] graphArray;
        private int[] graphVisitedArray;

        public Graph(int i) {
            graphArray = new int[i][i];
            graphVisitedArray = new int[i];
            for (int indexI = 0; indexI < i; indexI++) {
                for (int indexJ = 0; indexJ < i; indexJ++) {
                    graphArray[indexI][indexJ] = -1;
                }
                graphVisitedArray[indexI] = -1;
            }
        }

        public void addEdge(int i, int j) {
            graphArray[i][j] = 1;
        }

        public void BFS(int i) {
            List<Integer> listHelper = new ArrayList<>();
            BFSHelper(i, listHelper);
        }

        private void BFSHelper(int i, List<Integer> listHelper) {
            listHelper.add(i);
            System.out.println("Added child: " + i);
            visited(i);

//            get node i childs
            List<Integer> childs = getChilds(i);
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

// -1 -1 -1 -1
// -1 -1 -1 -1
// -1 -1 -1 -1
// -1 -1 -1 -1
