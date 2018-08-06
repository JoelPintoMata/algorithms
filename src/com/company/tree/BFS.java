package com.company.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    static int max = 0;
    static Queue<Integer> queue = new PriorityQueue<>();
    static Queue<Integer> maxQueue = new PriorityQueue<>();

    public static void main(String[] args) {
	    // write your code here
        BinaryTree tree = new BinaryTree();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.left.left= new Node(6);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();

        bfs(tree.root, 1);
        maxQueue.stream().forEach(x->System.out.println(x));
    }

    private static void bfs(Node node, int i) {
        queue.add(node.i);
        if(node.left == null && node.right == null) {
            if(i>max) {
                max = i;
                maxQueue = new PriorityQueue<>();
                maxQueue.addAll(queue);
            }
        }
        else {
            ++i;
            if (node.left != null) {
                bfs(node.left, i);
                queue.remove();
            }
            if (node.right != null) {
                bfs(node.right, i);
                queue.remove();
            }
        }
    }

    private static class BinaryTree {
        public Node root;

        public void printLevelOrder() {
        }
    }

    private static class Node {
        private final int i;

        public Node left;
        public Node right;

        public Node(int i) {
            this.i = i;
        }
    }
}
