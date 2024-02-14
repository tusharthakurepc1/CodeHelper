package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.ConstructTree;
import com.TreeDataStructure.TreeNode;

import java.sql.Connection;

public class CeilElement {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree11BST();

        ceil(root,8);
    }

    public static void ceil(TreeNode root,int target){
        int ceil_val = -1;
        while(root != null){
            if(root.val >= target){
                ceil_val = root.val;
                if(root.val == target)  break;
            }
            if(root.val > target){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        System.out.println(ceil_val);
    }
}
