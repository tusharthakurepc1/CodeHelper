import com.BasicLibTCT;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.*;

public class Test{

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 100);
        map.put(2, 100);
        map.put(3, 100);
        map.put(4, 100);

        System.out.println(map);

        map.forEach((a, b)->{
            System.out.println(a +" "+ b);
        });

    }

    public static void helper(List<List<Integer>> adj_list){
        boolean vis[] = new boolean[adj_list.size()];

        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(adj_list, vis, i);
            }
        }



    }

    public static void dfs(List<List<Integer>> adj_list, boolean vis[], int node){
        vis[node] = true;

//        Traverse all the child
        for(int el: adj_list.get(node)){
            if(!vis[el]){
                dfs(adj_list, vis, el);
            }
        }

        System.out.println(node);

    }


    public static void nextP(int arr[]){
        int ind = -1;

        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }

        if(ind == -1){
            reverse(arr, 0, arr.length-1);
            return;
        }


        System.out.println(Arrays.toString(arr));
        int data = arr[ind];
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] > data){
                System.out.println(i+" "+ind);
                swap(arr, i, ind);
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
        reverse(arr, ind+1, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void reverse(int arr[], int a, int b){
        while(a <= b){
            swap(arr, a, b);

            a++;
            b--;
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
