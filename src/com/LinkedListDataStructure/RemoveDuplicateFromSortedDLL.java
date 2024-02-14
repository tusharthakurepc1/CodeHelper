package com.LinkedListDataStructure;

public class RemoveDuplicateFromSortedDLL {
    public static void main(String[] args) {
        DLL dll=new DLL();
        DoubleLinkedList.insertionEnd(dll,5);
        DoubleLinkedList.insertionEnd(dll,5);
        DoubleLinkedList.insertionEnd(dll,5);
        DoubleLinkedList.insertionEnd(dll,10);
        DoubleLinkedList.insertionEnd(dll,10);
        DoubleLinkedList.insertionEnd(dll,10);
        DoubleLinkedList.insertionEnd(dll,10);
        DoubleLinkedList.insertionEnd(dll,30);

        dll.head = removeDuplicateInDoubleLL(dll.head);
        DoubleLinkedList.displayList(dll);

//        Node head = null;
//        head = SingleLinkList.insertionNodeHead(head, 10);
//        head = SingleLinkList.insertionNodeHead(head, 10);
//        head = SingleLinkList.insertionNodeHead(head, 20);
////        head = SingleLinkList.insertionNodeHead(head, 20);
//
//
//        SingleLinkList.displayLinkedList(removeDuplicateInSingleLL(head));
    }

/*
    This method is for removing the duplication of data in the Single Linked List
    Time Complexity: O(n)
    Space Complexity: O(1)
    Return the head of single linked list
 */
    public static Node removeDuplicateInSingleLL(Node head){
        if(head == null && head.next == null)    return head;

        Node temp = head;

//  Case if the element duplicate is at the start   (EDGE CASE)
        while(temp != null && temp.next != null && temp.data == temp.next.data){
            temp = temp.next;
        }
        head = temp;

//  Case if the element duplicate is at the middle      (NORMAL CASE)

        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            else    temp = temp.next;
        }

        return head;
    }

/*
    This Method is for removing the duplication of data in the Double Linked List
    Time Complexity: O(n)
    Space Complexity: O(1)
    return the head of double linked list
 */
    public static DLLNode removeDuplicateInDoubleLL(DLLNode head){
        if(head == null || head.next == null)   return head;

        DLLNode temp = head;
//  Case if the duplicate element is at the first   (BASE CASE)
        while(temp != null && temp.next != null && temp.data == temp.next.data){
            temp = temp.next;
        }
        head = temp;
        temp.prev = null;

//  Case if the duplicate element is at the middle  (NORMAL CASE)
        temp = head;

        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data) {
//                Delete the temp Node
                DLLNode temp_p = temp.prev;
                DLLNode temp_n = temp.next;

                if (temp_p != null) {
                    temp_p.next = temp_n;
                }
                if (temp_n != null) {
                    temp_n.prev = temp_p;
                }
            }
            temp = temp.next;
        }
        return head;
    }
}
