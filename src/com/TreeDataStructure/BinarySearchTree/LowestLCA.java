package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

public class LowestLCA {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree12BST();

        ConstructTree.inorder(root);

        System.out.println();
        iterativeSolution(root,1,3);
    }

    public static void iterativeSolution(TreeNode root,int node_val1,int node_val2){

            while(root != null){
                if(root.val > node_val1 && root.val > node_val2){
                    root = root.left;
                }
                else if(root.val < node_val1 && root.val < node_val2){
                    root = root.right;
                }
                else {
                    System.out.println(root.val);
                    break;
                }
            }

        System.out.println("Done");
    }
}
