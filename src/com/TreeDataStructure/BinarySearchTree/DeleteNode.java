package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

public class DeleteNode {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree12BST();

        ConstructTree.inorder(root);
        System.out.println();
//        root = solution1(root,4);
        root = solution2(root,6);
        ConstructTree.inorder(root);
    }
    public static TreeNode solution1(TreeNode root,int node_val){
        TreeNode original_root = root;
        TreeNode prev = null;
        TreeNode pos = root;
        while(root != null){
            prev = pos;
            pos = root;

            if(root.val == node_val){
                break;
            }

            if(root.val > node_val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }

        System.out.println(prev.val+" "+pos.val);

        if(prev != null && pos != null){
//            Deletion Algo

            TreeNode left_sub_tree = pos.left;
            TreeNode right_sub_tree = pos.right;

            if(prev == pos){
                original_root = right_sub_tree;
                TreeNode temp = right_sub_tree;
                while(temp != null && temp.left != null) temp = temp.left;

                temp.left = left_sub_tree;
                return original_root;
            }

            if(left_sub_tree == null && right_sub_tree == null){
                if(prev.left == pos)    prev.left = null;
                else   prev.right = null;

                return original_root;
            }

            if(prev.left == pos){
                prev.left = left_sub_tree;
                TreeNode temp = left_sub_tree;
                while(temp != null && temp.right != null) temp = temp.right;

                temp.right = right_sub_tree;
            }
            else{
                prev.right = right_sub_tree;
                TreeNode temp = right_sub_tree;
                while (temp != null && temp.right != null)  temp = temp.right;

                if(temp != null)
                    temp.right = left_sub_tree;
            }


        }
        return original_root;
    }


    public static TreeNode solution2(TreeNode root,int node_val){
        if(root.val == node_val){
            return deleteArrange(root);
        }

        TreeNode original_root = root;
        while(root != null){
            if(node_val > root.val){
//                To the right side
                if(root.right != null && root.right.val == node_val){
//                    System.out.println(root.right+" "+root.right.val);
                    root.right = deleteArrange(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
            else{
//                To the left side
                if(root.left != null && root.left.val == node_val){
//                    System.out.println(root.left+" "+root.left.val);
                    root.left = deleteArrange(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
        }

        return original_root;
    }


    public static TreeNode deleteArrange(TreeNode root){
        if(root == null)     return null;
        else if(root.left == null)   return root.right;
        else if(root.right == null)  return root.left;
        else{
            TreeNode left_st = root.left;
            TreeNode right_st = root.right;

            root = left_st;
            TreeNode right_largest = rightLargest(left_st);
            right_largest.right = right_st;

            return root;
        }
    }
    public static TreeNode rightLargest(TreeNode root){
        if(root.right == null){
            return root;
        }

        return rightLargest(root.right);
    }


}
