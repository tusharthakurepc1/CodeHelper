package com.LinkedListDataStructure;

public class RemoveLastNthNode {
    public static void main(String[] args) {
        Node head=null;


        head=SingleLinkList.insertionNodeHead(head,5);
        head=SingleLinkList.insertionNodeHead(head,4);
        head=SingleLinkList.insertionNodeHead(head,3);
        head=SingleLinkList.insertionNodeHead(head,2);
        head=SingleLinkList.insertionNodeHead(head,1);
//        head=SingleLinkList.reverseListRecursive(head,null,head,head.next);
//        SingleLinkList.displayLinkedList(head);

//        SingleLinkList.displayLinkedList(bruteForce(head, 2));

        SingleLinkList.displayLinkedList(optimalSolution(head, 2));

    }

    /*
       Time Complexity : O(2N)
       Space Complexity: O(1)
     */
    public static Node bruteForce(Node head, int pos){
        int length = 0;
        Node temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        int pos_front = length - pos;

        if(pos_front < 0)   return head;
        if(pos_front == 0)      return head.next;


        System.out.println(length+"  "+pos_front);
        temp = head;

        while(temp != null && pos_front != 1){
            pos_front--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static Node optimalSolution(Node head, int pos){
        Node fast = head;
        int var = pos;
        while(var != 0 && fast != null){
            fast = fast.next;
            var --;
        }
//        Now the fast at the desire pos

        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
