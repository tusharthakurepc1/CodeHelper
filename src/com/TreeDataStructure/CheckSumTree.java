package com.TreeDataStructure;

import com.Pair;

import java.awt.peer.ListPeer;

public class CheckSumTree {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();

        System.out.println(isCheckSumTree(root).first);

    }

    public static Pair isCheckSumTree(TreeNode root){
        //base case
        if(root == null){
            return new Pair(1, 0);
        }
        if(root.left == null && root.right == null){
            return new Pair(1, root.val);
        }

        Pair left = isCheckSumTree(root.left);
        Pair right = isCheckSumTree(root.right);

        int sum = left.second + right.second;

        if(left.first == 1 && right.first == 1 && sum == root.val){
            return new Pair(1, sum + root.val);
        }
        else{
            return new Pair(0, sum + root.val);
        }
    }
}
