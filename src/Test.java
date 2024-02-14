import com.BasicLibTCT;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.*;




public class Test{

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(4, "D");
        map.put(2, "B");
        map.put(3, "C");
        map.put(1, "A");

        System.out.println(map);

        for(Map.Entry<Integer, String> data: map.entrySet()){
            System.out.println(data);
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
