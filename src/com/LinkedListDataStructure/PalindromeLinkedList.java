package com.LinkedListDataStructure;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head=null;
        head=SingleLinkList.insertionNodeHead(head,1);
        head=SingleLinkList.insertionNodeHead(head,5);
        head=SingleLinkList.insertionNodeHead(head,4);
        head=SingleLinkList.insertionNodeHead(head,4);
//        head=SingleLinkList.insertionNodeHead(head,5);
        head=SingleLinkList.insertionNodeHead(head,1);

//        SingleLinkList.displayLinkedList(head);

//        System.out.println("Brute: "+bruteForce(head));

//        SingleLinkList.displayLinkedList(reverseList(head));

        System.out.println(optimalSolution(head));

//        System.out.println(checkPalindrome(head));  //original list will be changed.
    }

    public static boolean optimalSolution(Node head){
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node new_head = reverseList(slow.next);
        System.out.println(new_head);

        slow = head;
        fast = new_head;

        while(fast != null){
            if(slow.data != fast.data){
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        reverseList(new_head);
        return true;
    }

    public static boolean bruteForce(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while(temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null && !stack.isEmpty()){
            if(temp.data != stack.peek()){
                return false;
            }
            stack.pop();
            temp = temp.next;
        }

        if(stack.isEmpty()) return true;
        else    return false;
    }

    public static boolean checkPalindrome(Node head){
        Node slow=head,fast=head;
        Node prev=null;

        while(fast != null && fast.next != null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        Node iter=null;
        if(fast == null){
//            System.out.println("Even NOdes");
            prev = reversePos(prev,slow);

            iter = prev.next;
        }
        else{
//            System.out.println("ODD Nodes");
            slow = reversePos(slow,slow.next);

            iter = slow.next;
        }

        slow = head;
        while(iter != null){
            if(slow.data != iter.data){
                return false;
            }
            slow = slow.next;
            iter = iter.next;
        }
        return true;


//        SingleLinkList.displayLinkedList(head);
    }

    public static Node reversePos(Node pre,Node start){
        Node temp=start;
        Node prev=null,next=null;

        if(temp != null){
            next = temp.next;
        }

        while(temp != null){
            temp.next = prev;

            prev = temp;
            temp = next;
            if(next != null)
                next = next.next;
        }

        if(pre != null){
            pre.next = prev;
        }
        return pre;
    }

    public static Node reverseList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node new_head = reverseList(head.next);
        Node temp = head.next;

        temp.next = head;
        head.next = null;

        return new_head;
    }
}
