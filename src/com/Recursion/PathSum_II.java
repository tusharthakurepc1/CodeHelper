package com.Recursion;

import com.TreeDataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_II {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
        root.right = new TreeNode(-3);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(1);


        List<List<Integer>> res = new ArrayList<>();

        solution2(root, new ArrayList<>(), -5, res);

        System.out.println(res);

    }

    public static void solution(TreeNode root, List<Integer> res_t, int target, List<List<Integer>> res){
        if(root == null && target == 0){
            if(!res.contains(res_t)){
                res.add(new ArrayList<>(res_t));
            }
            return;
        }
        if(target < 0 || root == null){
            return;
        }

        res_t.add(root.val);
        //check for the left child
        if(root != null){
            solution(root.left, res_t, target - root.val, res);
        }

        //check for the right child
        if(root != null){
            solution(root.right, res_t, target - root.val, res);
        }

        res_t.remove(res_t.size()-1);
    }

    public static void solution2(TreeNode root, List<Integer> res_t, int target, List<List<Integer>> res){
        System.out.println(root.val);
        if(root.left == null && root.right == null && target - root.val == 0){
            res_t.add(root.val);
            res.add(new ArrayList<>(res_t));
            res_t.remove(res_t.size()-1);
            return;
        }

        res_t.add(root.val);
        //check for the left child
        if(root.left != null){
            solution2(root.left, res_t, target - root.val, res);
        }

        //check for the right child
        if(root.right != null){
            solution2(root.right, res_t, target - root.val, res);
        }

        res_t.remove(res_t.size()-1);
    }
}
