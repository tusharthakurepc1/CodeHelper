package com.TreeDataStructure;

import com.Pair;

public class HeightAndDiameterOfTree {
    public static void main(String[] args) {

        TreeNode root = ConstructTree.tree10();

        System.out.println(getHeight(root));

        System.out.println("Width is: "+getDiameterBruteForce(root)+" Op: "+getDiameterOptimal(root).first);
    }

    public static Pair getDiameterOptimal(TreeNode root){
        //base case
        if(root == null){
            //Pair (a, b)   a = diameter and b = height
            Pair temp = new Pair(0, 0);
            return temp;
        }

        Pair left = getDiameterOptimal(root.left);
        Pair right = getDiameterOptimal(root.right);


        int option1 = left.first;         //max diameter may be on the left sub tree
        int option2 = right.first;        //max diameter may be on the right sub tree

        int option3 = left.second + right.second + 1; //max diameter may be through the root node

        int diameter = Math.max(option1, Math.max(option2, option3));
        int height = Math.max(left.second, right.second) + 1;

        Pair res_t = new Pair(diameter, height);
        return res_t;
    }

    //Time complexity: O(nodes^2)
    //Space complexity: O(height)
    public static int getDiameterBruteForce(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        int option1 = getDiameterBruteForce(root.left);         //max diameter may be on the left sub tree
        int option2 = getDiameterBruteForce(root.right);        //max diameter may be on the right sub tree

        int option3 = getHeight(root.left) + getHeight(root.right) + 1; //max diameter may be through the root node

        int ans = Math.max(option1, Math.max(option2, option3));
        return ans;
    }


    //Time complexity: O(nodes)
    //Space complexity: O(height)           //using stack space for recursion
    public static int getHeight(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        int left_height = getHeight(root.left);
        int right_height = getHeight(root.right);

        int ans = Math.max(left_height, right_height) + 1;

        return ans;
    }


}
