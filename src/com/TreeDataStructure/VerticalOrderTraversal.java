package com.TreeDataStructure;

import java.util.*;
import java.util.TreeMap;

class TreeNodePosition{
    TreeNode root;
    int coordinate;
    int level;

    TreeNodePosition(){
        root = null;
        coordinate = 0;
        level = 0;
    }
    TreeNodePosition(TreeNode _root,int _coordinate,int _level){
        root = _root;
        coordinate = _coordinate;
        level = _level;
    }
}

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree2();

//        verticalTraversal(root);
        verticalTraversalM3(root);
    }

    public static void verticalTraversalM3(TreeNode root){
        Queue<TreeNodePosition> queue = new ArrayDeque<>();
        Map<Integer, Map<Integer,ArrayList<Integer>>> data_structure = new TreeMap<>();
//        coordinates, level and elements_data

        queue.offer(new TreeNodePosition(root,0,0));

        while(!queue.isEmpty()){
            TreeNodePosition temp = queue.poll();
            int coordinate = temp.coordinate;
            int level = temp.level;
            TreeNode node = temp.root;

            if(!data_structure.containsKey(coordinate)){
                data_structure.put(coordinate,new TreeMap<>());
            }
            if(!data_structure.get(coordinate).containsKey(level)){
                data_structure.get(coordinate).put(level,new ArrayList<>());
            }

            data_structure.get(coordinate).get(level).add(node.val);
            Collections.sort(data_structure.get(coordinate).get(level));

            if(node.left != null){
                queue.offer(new TreeNodePosition(node.left,coordinate-1, temp.level+1));
            }
            if(node.right != null){
                queue.offer(new TreeNodePosition(node.right,coordinate+1,temp.level+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(Map<Integer, ArrayList<Integer>> iter: data_structure.values()){
            List<Integer> res_t = new ArrayList<>();

            for(ArrayList<Integer> iter1: iter.values()){

                while(!iter1.isEmpty()){
                    res_t.add(iter1.remove(0));
                }

            }

            res.add(res_t);
        }

        System.out.println(data_structure);
        System.out.println(res);
    }

    public static void verticalTraversalM2(TreeNode root){
        Queue<TreeNodePosition> queue = new ArrayDeque<>();
        Map<Integer, PriorityQueue<Integer>> data_structure = new TreeMap<>();
//        coordinates and elements_data

        queue.offer(new TreeNodePosition(root,0,0));

        while(!queue.isEmpty()){
            TreeNodePosition temp = queue.poll();
            int coordinate = temp.coordinate;
            TreeNode node = temp.root;

            if(!data_structure.containsKey(coordinate)){
                data_structure.put(coordinate,new PriorityQueue<>());
            }
            data_structure.get(coordinate).offer(node.val);

            if(node.left != null){
                queue.offer(new TreeNodePosition(node.left,coordinate-1, temp.level+1));
            }
            if(node.right != null){
                queue.offer(new TreeNodePosition(node.right,coordinate+1,temp.level+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(PriorityQueue<Integer> iter: data_structure.values()){
            List<Integer> res_t = new ArrayList<>();
            while(!iter.isEmpty()){
                res_t.add(iter.poll());
            }
            Collections.sort(res_t);
            res.add(res_t);
        }

        System.out.println(data_structure);
        System.out.println(res);
    }


}
