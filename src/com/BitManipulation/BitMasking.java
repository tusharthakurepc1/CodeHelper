package com.BitManipulation;

public class BitMasking {
    public static void main(String[] args) {
//        Implements Set Data Structure using Bit Manipulation using Constant Space and Time.
//        Constraints Data Range from 0 to 60 and Time O(1) and Space O(1)


        Long data_main=0L;
//        data_main=~data_main;

        data_main=insertData(data_main,3);
        data_main=insertData(data_main,5);
        data_main=insertData(data_main,3);
        data_main=insertData(data_main,10);
        data_main=deleteData(data_main,3);
        display(data_main);
    }

    public static Long insertData(Long data_main,int data){
        data_main=data_main | (1 << data);

//        System.out.println(data_main);
        return data_main;
    }

    public static Long deleteData(Long data_main,int data){
        data_main=data_main & ~(1 << data);

        return data_main;
    }

    public static void display(Long data_main){
        Long temp=data_main;

        for(int i=0;i<64 && temp != 0;i++){
            if((temp & 1) == 1){
                System.out.println(i);
            }
            temp=temp>>1;
        }


    }

}
