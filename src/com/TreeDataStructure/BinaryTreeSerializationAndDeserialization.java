package com.TreeDataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializationAndDeserialization {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree1();
        ConstructTree.inorder(root);

        System.out.println();

//        System.out.println(serialization(root));

        deserialization(serialization(root));
    }


    public static String serialization(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder format = new StringBuilder("");

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(temp == null){
                format.append("$,");
                continue;
            }

            format.append(temp.val+",");


            queue.offer(temp.left);
            queue.offer(temp.right);

        }

//        System.out.println(format);
        return format.toString();
    }

    public static void deserialization(String format){
        String nodes_data[] = format.split(",");
        System.out.println(Arrays.toString(nodes_data));

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes_data[0]));
        queue.offer(root);
        System.out.println(nodes_data[0].getClass());

        for(int i=1;i<nodes_data.length;i++){
            TreeNode temp = queue.poll();

            if(!nodes_data[i].equals("$")){
                TreeNode left_ch = new TreeNode(Integer.parseInt(nodes_data[i]));
                temp.left = left_ch;
                queue.offer(left_ch);
            }
            i++;

            if(!nodes_data[i].equals("$")){
                TreeNode right_ch = new TreeNode(Integer.parseInt(nodes_data[i]));
                temp.right = right_ch;
                queue.offer(right_ch);
            }

        }




        ConstructTree.inorder(root);
    }

}
