package com.StringDataStructure;

public class CountAndSay {
    public static void main(String[] args) {
        solution(4);
    }

    public static void solution(int n){
        if(n == 1){
            System.out.println(1);
        }
        else if(n == 2){
            System.out.println(11);
        }
        else{
            StringBuilder str = new StringBuilder("11");
            StringBuilder res = new StringBuilder("");
            str.append("&");

            for(int i=3;i<=n;i++){
                int count = 1;
                res = new StringBuilder("");
                for(int j=1;j<str.length();j++){
                    if(str.charAt(j) == str.charAt(j-1)){
                        count++;
                    }
                    else{
                        res.append(count+""+str.charAt(j-1));
                        count = 1;
                    }
                }

                str = new StringBuilder(res);
                str.append('&');
            }
            System.out.println("STR: "+str);
            System.out.println("RES: "+res);

        }
    }
}
