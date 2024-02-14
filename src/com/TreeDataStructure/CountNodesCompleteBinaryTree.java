package com.TreeDataStructure;

public class CountNodesCompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree8CT();

//        int res[] = {0};
//        bruteForce(root,res);
//        System.out.println(res[0]);

        System.out.println(optimalSolution(root));
    }
    public static void bruteForce(TreeNode root,int res[]){
        if(root == null){
            return;
        }
        res[0]++;
        bruteForce(root.left,res);
        bruteForce(root.right,res);
    }

    public static int optimalSolution(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_height = leftHeight(root);
        int right_height = rightHeight(root);

        if(left_height == right_height){
            return (2 << left_height) - 1;
        }

        return 1 + optimalSolution(root.left) + optimalSolution(root.right);
    }

    public static int leftHeight(TreeNode root){
        int h = 0;

        while (root.left != null){
            h++;
            root = root.left;
        }

        return h;
    }

    public static int rightHeight(TreeNode root){
        int h = 0;

        while (root.right != null){
            h++;
            root = root.right;
        }

        return h;
    }

}
