package com.LinkedListDataStructure;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node head=null;
//        head=SingleLinkList.insertionNodeHead(head,6);
//        head=SingleLinkList.insertionNodeHead(head,5);
//        head=SingleLinkList.insertionNodeHead(head,4);
//        head=SingleLinkList.insertionNodeHead(head,3);
//        head=SingleLinkList.insertionNodeHead(head,2);
        head=SingleLinkList.insertionNodeHead(head,1);

        SingleLinkList.displayLinkedList(optimalSolution(head));

    }

    public static Node optimalSolution(Node head){
        if(head == null || head.next == null)   return null;
        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
