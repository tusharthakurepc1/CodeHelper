package com.TreeDataStructure;


import sun.reflect.generics.tree.Tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree5();

        ConstructTree.inorder(root);
        optimalSolution(root);
        System.out.println();
        ConstructTree.inorder(root);

        System.out.println();
        System.out.println(checkChildrenSumProperty(root));
    }
    public static int optimalSolution(TreeNode root){       //Time Complexity O(N)
        if(root == null){
            return 0;
        }

        int temp = 0;
        if(root.left != null)   temp += root.left.val;
        if(root.right != null)  temp += root.right.val;

        if(temp < root.val){
            if(root.left != null)   root.left.val = root.val;
            if(root.right != null)  root.right.val = root.val;
        }


        int left_res = optimalSolution(root.left);
        int right_res = optimalSolution(root.right);

        if(root.left == null && root.right == null){
            root.val = root.val + left_res + right_res;
        }
        else{
            root.val = left_res + right_res;
        }

        return root.val;
    }

    public static boolean checkChildrenSumProperty(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }

        int temp = 0;
        if(root.left != null)   temp += root.left.val;
        if(root.right != null)  temp += root.right.val;

        if(temp != root.val){
            return false;
        }

        boolean left_res = checkChildrenSumProperty(root.left);
        boolean right_res = checkChildrenSumProperty(root.right);

        if(left_res && right_res){
            return true;
        }
        else{
            return false;
        }


    }
}
