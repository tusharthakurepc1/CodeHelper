package com.TreeDataStructure;


import java.util.*;

class TreeNodePosition1{
    TreeNode root;
    int coordinate;
    int levels;

    TreeNodePosition1(){
        root = null;
        coordinate = 0;
    }
    TreeNodePosition1(TreeNode _root,int _coordinate){
        root = _root;
        coordinate = _coordinate;
    }
    TreeNodePosition1(TreeNode _root,int _coordinate,int _levels){
        root = _root;
        coordinate = _coordinate;
        levels = _levels;
    }
}

public class ViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();

//        getTopView(root);
//        getRightSideView(root);
        getBottomView(root);

    }

    public static void getTopView(TreeNode root){
        Map<Integer,Integer> data_structure = new TreeMap<>();
        Queue<TreeNodePosition1> queue = new ArrayDeque<>();

        queue.offer(new TreeNodePosition1(root,0));
        while(!queue.isEmpty()){
            TreeNodePosition1 temp = queue.poll();
            TreeNode node = temp.root;
            int coordinate = temp.coordinate;

            if(!data_structure.containsKey(coordinate)){
                data_structure.put(coordinate,node.val);
            }

            if(node.left != null){
                queue.offer(new TreeNodePosition1(node.left,coordinate-1));
            }
            if(node.right != null){
                queue.offer(new TreeNodePosition1(node.right,coordinate+1));
            }
        }

        System.out.println(data_structure);
    }

    public static void getRightSideView(TreeNode root){
        Map<Integer,Integer> data_structure = new TreeMap<>();
        Queue<TreeNodePosition1> queue = new ArrayDeque<>();

        queue.offer(new TreeNodePosition1(root,0,0));
        while(!queue.isEmpty()){
            TreeNodePosition1 temp = queue.poll();
            int level = temp.levels;
            TreeNode node = temp.root;

            if(!data_structure.containsKey(level)){
                data_structure.put(level,node.val);
            }

            if(node.right != null){
                queue.offer(new TreeNodePosition1(node.right,temp.coordinate+1,level+1));
            }
            if(node.left != null){
                queue.offer(new TreeNodePosition1(node.left,temp.coordinate-1,level+1));
            }

        }
        List<Integer> res = new ArrayList<>();
        for(int el:data_structure.values()){
            res.add(el);
        }

        System.out.println(data_structure);
        System.out.println(res);
    }

    public static void getBottomView(TreeNode root){
        Queue<TreeNodePosition1> queue = new ArrayDeque<>();
        Map<Integer,Integer> data_structure = new TreeMap<>();

        queue.offer(new TreeNodePosition1(root,0,0));

        while(!queue.isEmpty()){
            TreeNodePosition1 temp = queue.poll();
            int coordinate = temp.coordinate;
            int level = temp.levels;
            TreeNode node = temp.root;

            data_structure.put(coordinate,node.val);

            if(node.left != null){
                queue.offer(new TreeNodePosition1(node.left,coordinate-1,level+1));
            }
            if(node.right != null){
                queue.offer(new TreeNodePosition1(node.right,coordinate+1,level+1));
            }

        }
        System.out.println(data_structure);
    }
}
