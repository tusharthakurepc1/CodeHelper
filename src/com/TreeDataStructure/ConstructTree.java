package com.TreeDataStructure;

import sun.reflect.generics.tree.Tree;

public class ConstructTree {
    public static void main(String[] args) {
        inorder(tree3());
    }

    public static TreeNode tree1(){
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left =new TreeNode(4);
        root.left.right =new TreeNode(6);
        root.right =new TreeNode(3);
        root.right =new TreeNode(3);
        root.right.left =new TreeNode(5);
        root.right.right =new TreeNode(7);

        return root;
    }

    public static TreeNode tree2(){
        //[3,1,4,0,2,2]
        TreeNode root = new TreeNode(3);
        root.left =new TreeNode(1);
        root.left.left =new TreeNode(0);
        root.left.right =new TreeNode(2);
        root.right =new TreeNode(4);
        root.right.left =new TreeNode(2);

        return root;
    }

    public static TreeNode tree3(){
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right =new TreeNode(3);


        return root;
    }

    public static TreeNode tree4(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        return root;
    }

    public static TreeNode tree5(){
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

        return root;
    }

    public static TreeNode[] tree6(){
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left =new TreeNode(4);
        root.left.right =new TreeNode(6);
        root.right =new TreeNode(3);
        root.right.left =new TreeNode(5);
        root.right.right =new TreeNode(7);

        TreeNode res[] = new TreeNode[2];
        res[0] = root;
        res[1] = root.left;
        return res;
    }

    public static TreeNode[] tree7(){
        TreeNode root = new TreeNode(3);
        root.left =new TreeNode(5);
        root.left.left =new TreeNode(6);
        root.left.right =new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right =new TreeNode(1);
        root.right.left =new TreeNode(0);
        root.right.right =new TreeNode(8);

        TreeNode res[] = new TreeNode[2];
        res[0] = root;
        res[1] = root.left;
        return res;
    }

    public static TreeNode tree8CT(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        return root;
    }

    public static TreeNode tree9(){
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left =new TreeNode(4);
        root.left.right =new TreeNode(6);
        root.right =new TreeNode(3);
        root.right =new TreeNode(3);
        root.right.left =new TreeNode(5);
        root.right.right =new TreeNode(7);

        return root;
    }

    public static TreeNode tree10(){
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.left.left =new TreeNode(3);
        root.left.right =new TreeNode(4);

        root.right =new TreeNode(5);
        root.right.right =new TreeNode(6);
        root.right.right.left =new TreeNode(7);

        return root;
    }

    public static TreeNode tree11BST(){
        TreeNode root = new TreeNode(10);
        root.left =new TreeNode(5);
        root.left.left =new TreeNode(3);
        root.left.left.left =new TreeNode(2);
        root.left.left.right =new TreeNode(4);
        root.left.right =new TreeNode(6);
        root.left.right.right =new TreeNode(9);

        root.right =new TreeNode(13);
        root.right.left =new TreeNode(11);
        root.right.right =new TreeNode(14);

        return root;
    }

    public static TreeNode tree12BST(){
        TreeNode root = new TreeNode(4);
        root.left =new TreeNode(2);
        root.left.left =new TreeNode(1);
        root.left.right =new TreeNode(3);

        root.right =new TreeNode(7);
        root.right.left =new TreeNode(6);
        root.right.right =new TreeNode(14);

        return root;
    }

    public static void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
}
