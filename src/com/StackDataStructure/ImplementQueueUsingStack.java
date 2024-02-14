package com.StackDataStructure;

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        Stack s1=new Stack(1000);

        insertQueueUsingStack(s1,10);
        insertQueueUsingStack(s1,20);
        insertQueueUsingStack(s1,30);

//        System.out.println(s1.peek());
        System.out.println(peekQueueUsingStack(s1));

//        s1.displayStack();
    }

    public static boolean insertQueueUsingStack(Stack stack,int data){
        return stack.push(data);
    }

    public static boolean deleteQueueUsingStack(Stack stack){
        Stack temp=new Stack(stack.size);

        while(!stack.isEmpty()){
            temp.push(stack.peek());
            stack.pop();
        }

        boolean res=temp.pop();

        while(!temp.isEmpty()){
            stack.push(temp.peek());
            temp.pop();
        }
        return res;
    }

    public static int peekQueueUsingStack(Stack stack){
        Stack temp=new Stack(stack.size);

        while(!stack.isEmpty()){
            temp.push(stack.peek());
            stack.pop();
        }
        int res = temp.peek();

        while (!temp.isEmpty()){
            stack.push(temp.peek());
            temp.pop();
        }

        return res;
    }
}
