package com.TreeDataStructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
        left = null;
        right = null;
    }

    public TreeNode(int _val){
        val = _val;
        left = right = null;
    }

}

