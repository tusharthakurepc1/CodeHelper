package com.LinkedListDataStructure;

public class LengthOfCycle {
    public static void main(String[] args) {
        Node head=null;
        head=SingleLinkList.insertionNodeHead(head,5);
        Node last = head;
        head=SingleLinkList.insertionNodeHead(head,3);
        head=SingleLinkList.insertionNodeHead(head,10);
        Node temp = head;
        head=SingleLinkList.insertionNodeHead(head,4);
//        last.next = temp;


        SingleLinkList.displayLinkedList(head);
        System.out.println(optimalSolution(head));
//        System.out.println(getHeadOfLoop(head).data);


    }

    public static int optimalSolution(Node head){
        Node headOfLoop = getHeadOfLoop(head);
        if(headOfLoop == null){
            return 0;
        }
        Node copy = headOfLoop.next;
        int length = 1;
        while(headOfLoop != copy){
            length++;
            copy = copy.next;
        }

        return length;
    }

    public static Node getHeadOfLoop(Node head){
        Node slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
//                Intersection of loop
                slow = head;
                while(slow == head){
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
