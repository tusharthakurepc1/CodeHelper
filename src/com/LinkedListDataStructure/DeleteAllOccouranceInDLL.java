package com.LinkedListDataStructure;

public class DeleteAllOccouranceInDLL {
    public static void main(String[] args) {
        DLL dll=new DLL();

//        DoubleLinkedList.insertionEnd(dll,20);
//        DoubleLinkedList.insertionEnd(dll,10);
//        DoubleLinkedList.insertionEnd(dll,10);
//        DoubleLinkedList.insertionEnd(dll,10);
//        DoubleLinkedList.insertionEnd(dll,10);
//        DoubleLinkedList.insertionEnd(dll,30);


        dll.head = bruteForce(dll.head, 10);
        DoubleLinkedList.displayList(dll);
    }

    public static DLLNode bruteForce(DLLNode head, int key){
        DLLNode temp = head;
        if(temp == null){
            return null;
        }

//  Case if the element at the start        (BASE CASE)
        while(temp != null && temp.data == key){
            temp = temp.next;
        }
        head = temp;
        if(temp != null)    temp.prev = null;


//  Case is the element at the middle       (NORMAL CASE)
//        System.out.println("NC");
        temp = head;
        while(temp != null){
            if(temp.data == key){
//                Want to delete this node
                DLLNode temp_p = temp.prev;
                DLLNode temp_n = temp.next;

                if(temp_p != null){
                    temp_p.next = temp_n;
                }
                if(temp_n != null){
                    temp_n.prev = temp_p;
                }
            }
            temp = temp.next;
        }

        return head;
    }
}
