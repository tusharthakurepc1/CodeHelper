package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

import java.util.ArrayList;
import java.util.List;

public class Two_SumBST {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree12BST();

        List<Integer> inorder = new ArrayList<>();
        inorderToArray(root,inorder);

        System.out.println(inorder);

        bruteForce(inorder,10);
    }

    public static void inorderToArray(TreeNode root, List<Integer> inorder){
        if(root == null){
            return;
        }

        inorderToArray(root.left,inorder);
        inorder.add(root.val);
        inorderToArray(root.right,inorder);
    }

    public static void bruteForce(List<Integer> inorder,int k){
        int start = 0, end = inorder.size()-1;

        while(start < end){
            int sum = inorder.get(start) + inorder.get(end);

            if(sum == k){
                System.out.println(start+" "+end);
                break;
            }
            else if(sum < k){
                start++;
            }
            else{
                end--;
            }
        }
    }
}
