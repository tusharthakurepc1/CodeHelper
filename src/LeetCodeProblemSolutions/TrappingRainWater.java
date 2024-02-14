package LeetCodeProblemSolutions;

import com.BasicLibTCT;

public class TrappingRainWater {  //Problem no 42 Leetcode    not working for some test case otherwise it's perfect
    public static void main(String[] args) {
        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};

        algo(arr);
        optimisedAlgo(arr);

    }
    public static void algo(int arr[]){
        int res=0;
        int maxi=arr[0];
        int init_cap=1;

        int start =-1,end=-1;

        for(int i=1;i<arr.length;i++){
            if(arr[i] > maxi){
                maxi= arr[i];
            }
        }

        for(int oi=0;oi<maxi;oi++){
            System.out.println("Level"+(oi+1));
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= init_cap){
                    start=i;
                    end=start+1;
                    while(end < arr.length){
                        if(arr[end] >= init_cap){
                            break;
                        }
                        end++;
                    }
                    if(end != arr.length){
//                        Calculate Cap
                        int temp=(end-(start+1));
                        res+=temp;

                        System.out.println("\t"+start+" "+end+" Cap: "+temp);
                    }
//                    if(start != 0){
//                        i=start+(end-start);
//                    }
                }
                start=-1;   end=-1;

            }
            init_cap++;
        }

        System.out.println(res);

    }

    public static void optimisedAlgo(int arr[]){
        int left=0,right=arr.length-1;
        int left_max=0,right_max=0;

        int ans=0;

        while(left <= right){
            left_max= BasicLibTCT.max(left_max,arr[left]);
            right_max= BasicLibTCT.max(right_max,arr[right]);

            if(left_max < right_max){
                ans+=(left_max-arr[left]);
                left++;
            }
            else{
                ans+=(right_max-arr[right]);
                right--;
            }
        }

        System.out.println(ans);

    }
}
