package com.TreeDataStructure;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RootToNodePath {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree3();
        List<List<Integer>> res = new ArrayList<>();

//        recursiveSol(root,new ArrayList<>(),7);
        allPossiblePath(root,new ArrayList<>(),res);
        System.out.println(res);
    }

    public static boolean recursiveSol(TreeNode root, ArrayList<Integer> res, int dest){
        if(root == null){
            return false;
        }
        res.add(root.val);

        if(root.val == dest){
            System.out.println(res);
            return true;
        }

        boolean left_res = recursiveSol(root.left,res,dest);

        boolean right_res = recursiveSol(root.right,res,dest);

        if(!left_res || !right_res){
            res.remove(res.size()-1);
        }

        return false;
    }

    public static boolean allPossiblePath(TreeNode root,List<Integer> res_t,List<List<Integer>> res){
        if(root == null){
            return false;
        }

        res_t.add(root.val);

        boolean left_res = allPossiblePath(root.left,res_t,res);
        boolean right_res = allPossiblePath(root.right,res_t,res);

        if(root.left == null && root.right == null){
            List<Integer> res_tt = new ArrayList<>(res_t);
            if(!res.contains(res_tt)){
                res.add(res_tt);
            }
        }
        if(!left_res || !right_res){
            res_t.remove(res_t.size()-1);
        }

        return false;
    }
}
