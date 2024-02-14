package com.TreeDataStructure;

import sun.reflect.generics.tree.Tree;

import java.awt.image.ImageProducer;
import java.util.*;

public class GetParentsOfEachNodes {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree5();

        getParents(root);
    }

    public static Map<Integer,TreeNode> getParents(TreeNode root){
        Map<Integer,TreeNode> res = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(temp.left != null){
                queue.offer(temp.left);
                res.put(temp.left.val, temp);
            }
            if(temp.right != null){
                queue.offer(temp.right);
                res.put(temp.right.val, temp);
            }
        }

        return res;

    }




}
