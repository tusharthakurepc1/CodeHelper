package com.TreeDataStructure;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();

        boundaryTraversal(root);
    }

    public static void boundaryTraversal(TreeNode root){
/*
            Approach is to print the boundary traversal using 3 steps:
    1. print all the left side nodes excluding the leaf node
    2. print all the leaf nodes
    3. print all the right side nodes in reverse order

*/

        leftTraversal(root);
        bottomTraversal(root);

        if(root.right != null)
            rightTraversal(root.right);



    }

    public static void leftTraversal(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        System.out.println(root.val);
        if(root.left != null){
            leftTraversal(root.left);
        }
        else{
            leftTraversal(root.right);
        }
    }

    public static void bottomTraversal(TreeNode root){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            System.out.println(root.val);
        }
        bottomTraversal(root.left);
        bottomTraversal(root.right);

    }

    public static void rightTraversal(TreeNode root){
        if(root == null){
            return;
        }

        if(root.right != null){
            rightTraversal(root.right);
        }
        else{
            rightTraversal(root.left);
        }
        if(root.left != null || root.right != null){
            System.out.println(root.val);
        }

    }

}
