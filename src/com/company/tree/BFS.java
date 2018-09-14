package com.company.tree;


import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    static Queue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.printLevelOrder();

        bfs(tree.root, 1);
    }

    private static void bfs(Node node, int i) {
        queue.add(node);
        while (true) {
            Node thisNode = queue.poll();
            System.out.println(thisNode.i);

            if (thisNode.left == null) {
                queue.add(thisNode.left);
            }
            if (thisNode.right == null) {
                queue.add(thisNode.right);
            }
        }
    }

    private static class BinaryTree {
        public Node root;

        public void printLevelOrder() {
        }
    }

    private static class Node {
        public final int i;

        public Node left;
        public Node right;

        public Node(int i) {
            this.i = i;
        }
    }
}