package com.TreeDataStructure;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class AllNodeKDistance {
    public static void main(String[] args) {
//        TreeNode[] pointers = ConstructTree.tree6();

        TreeNode root[] = ConstructTree.tree7();

//        optimalSolution(root[1],root[0],2);
        Map<Integer, TreeNode> parents = GetParentsOfEachNodes.getParents(root[0]);
//        System.out.println(parents);
        List<Integer> res = new ArrayList<>();
        recursiveSolution(root[1],root[0],res,0,2,parents,new HashMap<>());
        System.out.println(res);
    }

    public static void optimalSolution(TreeNode root,TreeNode origin,int k){
        Map<Integer, TreeNode> parents = GetParentsOfEachNodes.getParents(origin);
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Boolean> node_flag = new HashMap<>();
        int iterator = 1;

        queue.offer(root);
        node_flag.put(root,true);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(!node_flag.containsKey(parents.get(temp))){
                queue.offer(parents.get(temp));
                node_flag.put(parents.get(temp),true);
            }
            if(!node_flag.containsKey(temp.left)){
                queue.offer(temp.left);
                node_flag.put(temp.left,true);
            }
            if(!node_flag.containsKey(temp.right)){
                queue.offer(temp.right);
                node_flag.put(temp.right,true);
            }
            iterator++;
        }

    }

    public static void recursiveSolution(TreeNode root, TreeNode origin, List<Integer> res,
                                         int iterator, int k, Map<Integer,TreeNode> parents,
                                         Map<TreeNode,Boolean> flags){
        if(root == null){
            return;
        }
        if(iterator >= k){
            if(iterator == k)   res.add(root.val);
            return;
        }
        flags.put(root,true);


        if(!flags.containsKey(parents.get(root.val))){
            recursiveSolution(parents.get(root.val),origin,res,iterator+1,k,parents,flags);
        }
        if(!flags.containsKey(root.left)){
            recursiveSolution(root.left,origin,res,iterator+1,k,parents,flags);
        }
        if(!flags.containsKey(root.right)){
            recursiveSolution(root.right,origin,res,iterator+1,k,parents,flags);
        }

    }
}
