package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1NammaYatri {
    public static void main(String[] args) {
        int arr[] = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 12, 15, 22, 22, 22, 22, 22, 21};


        /*
         *   In this problem each each element represent a particular node and each node value range from 0 to arr.length-1
         *   You have to find the node having maximum no of in-degree from all of this
         *
         *   Expected Answer is: 22
         */

        findMaxInDegree(arr);
//        findMaxInDegreeUsingMap(arr);

    }

    public static void findMaxInDegreeUsingMap(int arr[]){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i])+1);
        }

        final int[] maxi = {-1};
        final int[] maxi_val = {-1};

        map.forEach((a, b)->{
            if(b > maxi[0]){
                maxi[0] = b;
                maxi_val[0] = a;
            }
        });

        System.out.println(maxi_val[0]);
    }

    public static void findMaxInDegree(int arr[]){
        List<List<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<arr.length;i++)   adj_list.add(new ArrayList<>());

        for(int i=0;i<arr.length;i++){
            if(arr[i] != -1)
                adj_list.get(arr[i]).add(i);
        }

        int maxi = -1;
        int maxi_val = -1;
        for(int i=0;i<adj_list.size();i++){
            if(adj_list.get(i).size() > maxi){
                maxi = adj_list.get(i).size();

                maxi_val = i;
            }
        }

        System.out.println(maxi_val);
    }



}
