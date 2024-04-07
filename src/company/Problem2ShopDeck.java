package company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem2ShopDeck {
    public static void main(String[] args) {
        int arr[] = {44, 3, 22, 7, 8, 22, 22, 22, 3, 1};

//        solution(arr, arr.length);

        optimalSolution(arr, arr.length);
    }



    public static void optimalSolution(int arr[], int n){

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){

            if(set.contains(arr[i])) System.out.println(arr[i]);
            else    set.add(arr[i]);

        }
    }

    //Time complexity: O(2n) which is linear
    //Space complexity: O(n) which is linear
    public static void solution(int arr[], int n){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){

            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }

        map.forEach((key, val)->{
            if(val == 2){
                System.out.println(key);
            }
        });


    }





}
