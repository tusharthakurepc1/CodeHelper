package LeetCodeProblemSolutions;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
//        int arr[] = {2, 1, 5, 4, 3, 0, 0};
//        optimalSolution(arr);
        int arr[] = {1, 2, 3};

        ArrayList<Integer> res = new ArrayList<>();

//        permutation(arr, 0);

        combination(arr, arr.length-1, res);
    }

    public static void combination(int arr[], int i, ArrayList<Integer> res){
        if(i == -1){
            System.out.println(res);
            return;
        }

        int el = arr[i];
        combination(arr, i-1, res);

        res.add(el);
        combination(arr, i-1, res);
        res.remove(res.size()-1);


    }


    public static void permutation(int arr[], int i){
        if(i == arr.length-1){
            System.out.println(Arrays.toString(arr));
        }

        for(int ct = i;ct < arr.length;ct++){
            localSwap(arr, i, ct);

            permutation(arr, i+1);

            localSwap(arr, i, ct);
        }
    }

    public static void optimalSolution(int arr[]){
        int pos = -1;

        for(int i = arr.length-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                pos = i;
                break;
            }
        }

        if(pos == -1){
            System.out.println(Arrays.toString(arr));
            return;
        }

//        System.out.println(pos);

        for(int i=arr.length-1;i>=pos;i--){
            if(arr[i] > arr[pos]){
                localSwap(arr, i, pos);
                break;
            }
        }
        localReverse(arr, pos+1, arr.length-1);


        System.out.println(Arrays.toString(arr));
    }

    public static void localSwap(int arr[],int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void localReverse(int arr[],int start, int end){
        while(start < end){
            localSwap(arr, start, end);
            start++;
            end--;
        }
    }
}
