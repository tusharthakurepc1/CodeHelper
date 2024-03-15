package com.DynamicProgramming.Tree;

import com.TreeDataStructure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HouseRobber3 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);

//        maximumCost(root);


    }




//    not working fine.....
    public static void maximumCost(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        boolean level_even = true;
        queue.offer(root);
        int total_cost[] = {0, 0};

        while(!queue.isEmpty()){
            int length = queue.size();

            for(int i=0;i<length;i++){
                TreeNode temp = queue.poll();
                if(level_even)  total_cost[0] += temp.val;
                else    total_cost[1] += temp.val;

                if(temp.left != null)   queue.offer(temp.left);
                if(temp.right != null)  queue.offer(temp.right);
            }

            level_even = !level_even;
        }

        System.out.println(Arrays.toString(total_cost));

    }
}
