package com.CP;

public class AdditiveNumber {
    public static void main(String[] args) {
        String pattern = "199100199";

//        System.out.println(additiveNumber(pattern, 0, 1, 1, Short.MAX_VALUE));
//        System.out.println(findSum(pattern, 1, 2, 3, 199));

        System.out.println(pattern.length());
        System.out.println(helper(pattern, 0));
    }

    public static boolean helper(String pattern, int ind){
//        int i = 1, j = 2;
        if(ind >= pattern.length()){
            return true;
        }



        for(int i=1;i<pattern.length()-1;i++){
            for(int j=1;j<pattern.length();j++){

                if(pattern.length() - (j+i) < Math.max(i, j))  continue;
//                System.out.println(i+" "+j+" "+ (pattern.length() - (j+i)));

                int a = Integer.parseInt(pattern.substring(ind, ind+i));
                int b = Integer.parseInt(pattern.substring(ind+i, ind+i+j));
                int c = a + b;

                System.out.println(ind+" " +i+" "+j+" Sum:"+c);
                if(findSum2(pattern, ind, i, j, c)){
                    return helper(pattern, ind+i);
                }

            }
        }
        return false;
    }

    public static boolean findSum2(String pattern, int ind, int i, int j, int sum){
        for(int counter = ind+i+j+1 ;counter <= pattern.length();counter++){
            System.out.println(sum);

            int temp = Integer.parseInt(pattern.substring(ind + i + j, counter));
//            System.out.println("Find"+ sum+" "+temp);
            if(temp == sum){
                return true;
            }
        }
        return false;
    }


    public static boolean additiveNumber(String pattern, int ind, int l1, int l2, int temp){
        if(ind + l1 + l2 >= pattern.length()){
            if(temp >= 0)   return true;
            return false;
        }

        String s1 = pattern.substring(ind, ind + l1);
        String s2 = pattern.substring(ind+l1, ind+l1+l2);
        int sum = Integer.parseInt(s1) + Integer.parseInt(s2);

        int res_t = findSum(pattern, ind, l1, l2, sum);
        System.out.println(sum+" l1:"+l1+" l2:"+l2+"    Index:"+ind+" res_t:"+res_t);


        if(res_t != -1){
            return additiveNumber(pattern, ind+l1, l2, res_t, res_t);
        }
        else{
            return additiveNumber(pattern, ind, l1, l2+1, res_t) ||
            additiveNumber(pattern, ind, l1+1, l2, res_t);
        }

    }

    public static int findSum(String pattern, int ind, int l1, int l2, int sum){
        for(int i=ind+l1+l2+1;i<=pattern.length();i++){
            String find_sum = pattern.substring(ind+l1+l2, i);
            int find_sum_int = Integer.parseInt(find_sum);

            if(sum == find_sum_int){
                System.out.println(sum+" Found***");
                return i - (l1+l2+ind);
            }
        }
        return -1;
    }


}
