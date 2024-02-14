package com.TreeDataStructure;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        int postorder[] = {40,50,20,60,30,10};
        int inorder[] = {40,20,50,10,60,30};

        Map<Integer,Integer> map = inorderToMap(inorder);
        System.out.println(map);

        ConstructTree.inorder(binaryTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map));
    }
    public static TreeNode binaryTree(int inorder[],int si,int ei,
                                  int postorder[],int ep,int sp,Map<Integer,Integer> map){
        if(si > ei || sp < ep){
            return null;
        }

        int root_inorder_pos = map.get(postorder[sp]);
        int root_post_pos = sp - (ei - root_inorder_pos);
        System.out.println("INORDER: "+si+" "+ei+" POSTORDER: "+sp+" "+ep+" Temp: "+root_inorder_pos);

        TreeNode root = new TreeNode(inorder[root_inorder_pos]);

        root.right = binaryTree(inorder,root_inorder_pos+1,ei,postorder,root_post_pos,sp-1,map);
//        For Right Node

        root.left = binaryTree(inorder,si,root_inorder_pos-1,postorder,ep,root_post_pos-1,map);
//        For Left Node

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
