package com.TreeDataStructure.BinarySearchTree;

import com.TreeDataStructure.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        int preorder[] = {8,5,1,7,10,12};

//        bruteForce(preorder);
//        ConstructTree.inorder(root);
        ConstructTree.inorder(optimalSolution(preorder,Integer.MAX_VALUE,new int[]{0}));
    }

//    NOTE: In BST the inorder of tree is always sorted.
    public static void bruteForce(int preorder[]){
        int inorder[] = preorder;
        Arrays.sort(inorder);

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i+1);
        }

        System.out.println(map);

    }

    public static TreeNode optimalSolution(int preorder[],int ub,int i[]){
        if(i[0] >= preorder.length || preorder[i[0]] > ub){
            return null;
        }
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = optimalSolution(preorder,root.val,i);
        root.right = optimalSolution(preorder,ub,i);

        return root;
    }
}
