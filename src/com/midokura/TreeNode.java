package com.midokura;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * public class TreeNode {
 * TreeNode parent;
 * TreeNode findFirstCommonAncestor(TreeNode other);
 * }
 * <p>
 * Implement the 'findFirstCommonAncestor' method that given another TreeNode
 * finds the first (deepest in the tree) common ancestor of 'this' TreeNode and
 * the one passed to the method. Assume that each TreeNode is a node in a
 * binary tree. You may add methods but not data members to the TreeNode class.
 */
public class TreeNode {

    TreeNode parent;

    public static void main(String[] a) {
        /*
        root
        treenode1               treenode2
        treenode3   treenode4   treenode5   treenode6
         */
        TreeNode root = new TreeNode();

        TreeNode treeNode1 = new TreeNode();
        treeNode1.parent = root;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.parent = root;

        TreeNode treeNode3 = new TreeNode();
        treeNode3.parent = treeNode1;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.parent = treeNode1;

        TreeNode treeNode5 = new TreeNode();
        treeNode5.parent = treeNode2;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.parent = treeNode2;

        Assertions.assertEquals(treeNode3.findFirstCommonAncestor(treeNode4), treeNode1);
        Assertions.assertEquals(treeNode1.findFirstCommonAncestor(treeNode3), root);
        Assertions.assertEquals(treeNode1.findFirstCommonAncestor(treeNode4), root);
        Assertions.assertEquals(treeNode1.findFirstCommonAncestor(treeNode5), root);
        Assertions.assertEquals(treeNode1.findFirstCommonAncestor(treeNode6), root);

        treeNode2.findFirstCommonAncestor(treeNode3);
        treeNode2.findFirstCommonAncestor(treeNode4);
        treeNode2.findFirstCommonAncestor(treeNode5);
        treeNode2.findFirstCommonAncestor(treeNode6);
    }

    TreeNode findFirstCommonAncestor(TreeNode other) {
        Set<TreeNode> mapT = new HashSet<>();
        Set<TreeNode> mapO = new HashSet<>();
        TreeNode t = this.parent;
        TreeNode o = other.parent;
        while (true) {
//            if both nodes are the same it is the common ancestor
            if (t == o) {
                return t;
            } else if (mapO.contains(t)) {
//            if while going up though `this` we arrive at a node visited while going up through `other`
//            then we found a shared node, that is, a common ancestor
                return t;
            } else if (mapT.contains(o)) {
//                if while going up though `other` we arrive at a node visited while going up through `this`
//                then we found a shared node, that is, a common ancestor
                return o;
            } else {
                if (t != null) {
                    mapT.add(t);
                    t = t.parent;
                }
                if (o != null) {
                    mapO.add(o);
                    o = o.parent;
                }
            }
        }
    }
}