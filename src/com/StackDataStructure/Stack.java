package com.StackDataStructure;

public class Stack {
    public int arr[];
    private int top;
    public int size;

    Stack(int n){
        arr=new int[n];
        top = -1;
        size = n;
    }

    public boolean isEmpty(){
        if(this.top <= -1){
            return  true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.top >= size){
            return true;
        }
        return false;
    }

    public boolean push(int data){  //Return true if successfully push otherwise return false.
        if(this.top >= size){
            return false;
        }
        else{
            top++;
            arr[top]=data;
            return true;
        }
    }

    public boolean pop(){   //Return true if successfully pop otherwise return false.
        if(this.top <= -1){
            return false;
        }
        else{
            arr[top] = 0;
            top--;
            return true;
        }
    }

    public int peek(){
        if(this.top >= 0 && this.top <= size-1){
            return arr[top];
        }
        else{
            return -1;
        }
    }

    public void displayStack(){
        for(int i=top;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
