package com.LinkedListDataStructure;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head=null;

        head=SingleLinkList.insertionNodeHead(head,5);
        head=SingleLinkList.insertionNodeHead(head,4);
        head=SingleLinkList.insertionNodeHead(head,3);
        head=SingleLinkList.insertionNodeHead(head,2);
        head=SingleLinkList.insertionNodeHead(head,1);

        SingleLinkList.displayLinkedList(head);

//        SingleLinkList.displayLinkedList(bruteForce(head));
//        SingleLinkList.displayLinkedList(optimalSolution(head));

        SingleLinkList.displayLinkedList(recursiveSolution(head));
    }

    public static Node recursiveSolution(Node node){
        if(node.next == null || node == null){
            return node;
        }

        Node head = recursiveSolution(node.next);

        Node right =  node.next;
        node.next = null;
        right.next = node;

        return head;
    }

    public static Node optimalSolution(Node head){
        Node prev = null;
        Node temp = head;

        while(temp != null){
            Node temp_next = temp.next;

            temp.next = prev;
            prev = temp;
            temp = temp_next;
        }

        return prev;
    }

    /*
    #Not Prefer because it is just manipulating the data which is not good in linked list.
        Time: O(2n)
        Space: O(n)
     */
    public static Node bruteForce(Node head){
        Stack<Integer> stack = new Stack<>();

        Node temp = head;
        while (temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }


        temp = head;
        while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }


        return head;
    }
}
