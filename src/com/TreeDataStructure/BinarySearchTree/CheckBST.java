package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

public class CheckBST {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();

        System.out.println(checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    public static boolean checkBST(TreeNode root,int lb,int ub){
        if(root == null){
            return true;
        }

        if(lb >= root.val || root.val >= ub){
            return false;
        }


        return checkBST(root.left,lb,root.val) && checkBST(root.right,root.val,ub);
    }
}
