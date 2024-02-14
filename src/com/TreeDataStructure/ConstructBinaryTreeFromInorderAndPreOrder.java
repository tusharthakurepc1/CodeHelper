package com.TreeDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreOrder {
    public static void main(String[] args) {
        int preorder[] = {10,20,40,50,30,60};
        int inorder[] = {40,20,50,10,60,30};

        Map<Integer,Integer> map = inorderToMap(inorder);

        ConstructTree.inorder(binaryTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map));

    }

    public static TreeNode binaryTree(int preorder[],int sp,int ep,
                                  int inorder[],int si,int ei,
                                  Map<Integer,Integer> map){
        if(sp > ep || si > ei){
            return null;
        }
        System.out.println("PERORDER: "+sp+" "+ ep+" INORDER: "+si+" "+ei);

        int root_pos = map.get(preorder[sp]);
        int pre_root_pos = (sp+1) + ((root_pos - 1) - si) ;

        TreeNode root = new TreeNode(inorder[root_pos]);


        root.left = binaryTree(preorder,sp+1,pre_root_pos,inorder,si,root_pos - 1,map);
        //Left Sub Tree

        root.right = binaryTree(preorder,pre_root_pos+1,ep,inorder,root_pos+1,ei,map);
        //Right Sub Tree

        return root;
    }

    public static Map<Integer,Integer> inorderToMap(int inorder[]){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return map;
    }
}
