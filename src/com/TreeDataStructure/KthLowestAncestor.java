package com.TreeDataStructure;

import com.CP.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthLowestAncestor {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.tree4();

        ConstructTree.inorder(root);

        int res[] = {-1};
        bruteForce(root, 2, 1, new ArrayList<>(), res);
        System.out.println();
        System.out.println(res[0]);

    }

    public static void bruteForce(TreeNode root, int node, int k, List<Integer> path, int res[]){
        if(root == null){
            return;
        }
        path.add(root.val);

        if(root.val == node){
            //here you have answer
            if(path.size() < k){
                return;
            }

            int i=path.size()-1;
            for(; i>path.size()-k-1; i--){ }

            if(i >= 0)  res[0] = path.get(i);

            path.remove(path.size()-1);
            return;
        }

        //left child
        bruteForce(root.left, node, k, path, res);
        //right child
        bruteForce(root.right, node, k, path, res);

        path.remove(path.size()-1);

    }

}
