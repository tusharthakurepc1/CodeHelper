package company;

import java.util.Arrays;

public class Problem3ShopDeck {
    public static void main(String[] args) {
        String str = "abcdabcef";
        String key = "cdaf";

//        bruteForce(str, key);
        optimalSolution(str, key);
    }

    public static void optimalSolution(String str, String key){
        int hash[] = new int[170];
        String res = str;

        for(int i=0; i<key.length(); i++)   hash[key.charAt(i)] += 1;
        int count = 0;

        int max_len = str.length();

        int left = 0;
        int n = str.length();
        for(int right=0; right<n; right++){



            if(hash[str.charAt(right)] > 0){
                hash[str.charAt(right)] -= 1;
                count += 1;
            }

            max_len = Math.min(max_len, right-left + 1);
        }

        System.out.println(count + " "+ max_len);
    }

    public static void bruteForce(String str, String key){
        int hash[] = new int[170];
        String res = str;

        int n = str.length();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){

                String sub_str = str.substring(i, j);

                for(int k=0; k<sub_str.length(); k++){
                    hash[sub_str.charAt(k)] += 1;
                }

                boolean flag = true;
                for(int k=0; k<key.length(); k++){
                    if(hash[key.charAt(k)] > 0){
                        hash[key.charAt(k)] -= 1;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }

                if(flag && sub_str.length() < res.length()){
                    res = sub_str;
                }

                Arrays.fill(hash, 0);
            }
        }

        System.out.println(res);
    }
}
