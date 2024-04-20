import com.BasicLibTCT;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.*;

public class Test{

    public static void main(String[] args) {

        String str = "leetcode";
        String revStr = new StringBuilder(str).reverse().toString();


        System.out.println(str+"\n"+revStr);

        int dp_arr[][] = new int[str.length()][str.length()];
        for(int temp[]: dp_arr) Arrays.fill(temp, -1);
        System.out.println(reccSolution(str, 0, str.length()-1, dp_arr));


    }

    public static int reccSolution(String s1, int start, int end, int dp_arr[][]){
        //base case
        if(start >= end){
            return 0;
        }
        if(dp_arr[start][end] != -1){
            return dp_arr[start][end];
        }

        if(s1.charAt(start) == s1.charAt(end)){
            return dp_arr[start][end] = reccSolution(s1, start + 1, end - 1, dp_arr);
        }
        else{

            int insertOne = reccSolution(s1, start + 1, end, dp_arr);
            int insertTwo = reccSolution(s1, start, end - 1, dp_arr);


            return dp_arr[start][end] = (1 + Math.min(insertOne, insertTwo));
        }
    }


    public static void tabulationSolution(String str){
        int dp_arr[][] = new int[str.length()][str.length()];
        //start > end make it 0;        start = 0, end = n-1






    }




    public static void mapHelper(){
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



}
