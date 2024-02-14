package com.LinkedListDataStructure;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {



    }

    public static Node optimalSolution(Node head1, Node head2){
        Node t1 = head1, t2 = head2;

        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        Node start1 = head1;
        Node start2 = head2;


        if(t1 == null && t2 != null){
//          List 1 is shorter
            while(t2 != null){
                start2 = start2.next;
                t2 = t2.next;
            }

        }
        else if(t2 == null && t1 != null){
//            List 2 is shorter
            while(t1 != null){
                start1 = start1.next;
                t1 = t1.next;
            }
        }

        while(start1 != null && start2 != null){
            if(start1 == start2){
                return start1;
            }
            start1 = start1.next;
            start2 = start2.next;
        }

        return null;
    }
}
