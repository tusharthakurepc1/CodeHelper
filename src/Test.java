import com.BasicLibTCT;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.*;




public class Test{

    public static void main(String[] args) {

        int arr[] = {9, 0, 2, 4, 7, 8};



    }
    public static void helper(int arr[]){
        int start = 0, end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] <= arr[end]){
                //Right side sorted
            }

        }
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
