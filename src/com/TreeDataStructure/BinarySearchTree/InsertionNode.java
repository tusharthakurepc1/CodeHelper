package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

public class InsertionNode {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree12BST();
//        TreeNode root = null;


        ConstructTree.inorder(root);
        System.out.println();
//        bruteForce(root,5);
        root = solution2(root,5);
        ConstructTree.inorder(root);
        System.out.println();

    }

    public static void bruteForce(TreeNode root,int node_val){
        TreeNode new_node = new TreeNode(node_val);
        while(root.left != null || root.right != null){
            System.out.println(root.val);

            if(root.val > node_val){
                root = root.left;
            }
            else if(root.val < node_val){
                root = root.right;
            }

        }

        if(root.val > node_val){
            root.left = new_node;
        }
        else if(root.val < node_val){
            root.right = new_node;
        }

    }

    public static TreeNode solution2(TreeNode root,int node_val){
        if(root == null){
            root = new TreeNode(node_val);
            return root;
        }
        TreeNode temp = root;
        while(true){
            if(root.val > node_val){
                if(root.left != null)   root = root.left;
                else{
                    root.left = new TreeNode(node_val);
                    break;
                }
            }
            else{
                if(root.right != null)  root = root.right;
                else {
                    root.right = new TreeNode(node_val);
                    break;
                }
            }
        }

        return temp;
    }
}
