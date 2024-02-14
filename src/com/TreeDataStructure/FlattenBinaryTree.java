package com.TreeDataStructure;

public class FlattenBinaryTree {
    static TreeNode prev = null;
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree10();

        optimalSolution(root);
        ConstructTree.inorder(root);
        System.out.println();
    }

    public static void optimalSolution(TreeNode root){
        if(root == null)    return;

        optimalSolution(root.right);
        optimalSolution(root.left);

        System.out.println(root.val);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
