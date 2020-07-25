package com.stenal.pp;

/*
Author: Stenal P Jolly
Problem:
2. Given a binary tree, find the height of the binary tree. (Mandatory)
Input: Root node of the tree
Output: Height of the tree
 */

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeHeight {
    static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);

            return Math.max(lDepth, rDepth) + 1;
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        if (test.runTest()) {
            System.out.println("All test passed");
        }else {
            System.out.println("Tests failed");
        }
    }

    static class Test {
        boolean runTest(){
            boolean result = true;
            result &= test();
            result &= test2();
            result &= test3();
            result &= test4();
            result &= test5();
            return result;
        }

        boolean test(){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            return TreeHeight.maxDepth(root) == 3;
        }

        boolean test2(){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(2);
            root.right.left.left = new TreeNode(8);
            root.right.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            return TreeHeight.maxDepth(root) == 4;
        }

        boolean test3(){
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.left.left.left = new TreeNode(2);
            root.left.left.left.left = new TreeNode(2);

            return TreeHeight.maxDepth(root) == 5;
        }

        boolean test4(){
            TreeNode root = new TreeNode(1);
            return TreeHeight.maxDepth(root) == 1;
        }

        boolean test5(){
            return TreeHeight.maxDepth(null) == 0;
        }
    }
}
