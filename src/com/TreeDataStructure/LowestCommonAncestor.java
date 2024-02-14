package com.TreeDataStructure;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree4();

//        lcaBruteForce(root,4,7);
//        getPathFromRoot(root,1,new ArrayList<>());
        System.out.println(lcaOptimalM2(root,new TreeNode(4),new TreeNode(7)));
//        System.out.println(lcaOptimal(root,new TreeNode(4),new TreeNode(7)));
    }

    public static void lcaBruteForce(TreeNode root,int n1,int n2){
        List<Integer> path1 = new ArrayList<>();
        getPathFromRoot(root,n1,path1);
        List<Integer> path2 = new ArrayList<>();
        getPathFromRoot(root,n2,path2);

        for(int i=0;i<Math.min(path1.size(), path2.size());i++){

            if(path1.get(i) != path2.get(i)){
                if(i <= 0){
                    System.out.println("Invalid");
                }
                else{
                    System.out.println(path1.get(i-1));
                }
                break;
            }
        }
    }

    public static boolean getPathFromRoot(TreeNode root, int dest, List<Integer> path){
        if(root == null){
            return false;
        }
        path.add(root.val);

        if(root.val == dest){

            return true;
        }

        boolean left_res = getPathFromRoot(root.left,dest,path);
        boolean right_res = getPathFromRoot(root.right,dest,path);

        if(left_res || right_res){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static TreeNode lcaOptimal(TreeNode root,TreeNode n1,TreeNode n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }

        TreeNode left_res = lcaOptimal(root.left,n1,n2);
        TreeNode right_res = lcaOptimal(root.right,n1,n2);

        if(left_res == null){
            return right_res;
        }
        else if(right_res == null){
            return left_res;
        }
        else{
            return root;
        }
    }

    public static TreeNode lcaOptimalM2(TreeNode root,TreeNode n1,TreeNode n2){
        if(root == null || root == n1 || root == n2){
            return root;
        }

        TreeNode left_res = lcaOptimalM2(root.left,n1,n2);
        TreeNode right_res = lcaOptimalM2(root.right,n1,n2);

        if(left_res == null){
            return right_res;
        }
        else if(right_res == null){
            return left_res;
        }
        else{
            return root;
        }

    }
}
