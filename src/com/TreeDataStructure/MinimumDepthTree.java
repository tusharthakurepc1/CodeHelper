package com.TreeDataStructure;

public class MinimumDepthTree {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();


    }
    public static int minimumDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = minimumDepth(root.left);
        int right = minimumDepth(root.right);

        if(left == 0 || right == 0){
            return 1 + left + right;
        }
        else{
            return 1 + Math.min(left, right);
        }
    }
}
