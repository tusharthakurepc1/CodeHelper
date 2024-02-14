package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.ConstructTree;
import com.TreeDataStructure.TreeNode;

public class FloorElement {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree11BST();

        floor(root,8);
    }
    public static void floor(TreeNode root,int target){
        int floor_val = -1;
        while(root != null){
            if(root.val <= target){
                floor_val = root.val;
                if(root.val == target)  break;
            }

            if(root.val > target){
                root = root.left;
            }
            else{
                root = root.right;
            }

        }
        System.out.println(floor_val);
    }
}
