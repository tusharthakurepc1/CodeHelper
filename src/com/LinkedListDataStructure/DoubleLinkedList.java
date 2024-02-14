package com.LinkedListDataStructure;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DLL dll=new DLL();

        insertionEnd(dll,10);
        insertionEnd(dll,20);
        insertionEnd(dll,30);

        displayList(dll);
    }

    public static void insertionStart(DLL dll,int data){
        DLLNode new_node=new DLLNode(data);

        if(dll.head == null && dll.tail == null){
            dll.head = new_node;
            dll.tail = new_node;
        }
        else{
            DLLNode temp = dll.head;

            dll.head = new_node;
            new_node.next = temp;
            temp.prev = new_node;
        }
    }

    public static void insertionEnd(DLL dll,int data){
        DLLNode new_node = new DLLNode(data);

        if(dll.head == null && dll.tail == null){
            dll.head = new_node;
            dll.tail = new_node;
        }
        else{
            DLLNode temp = dll.tail;

            dll.tail = new_node;
            new_node.prev = temp;
            temp.next = new_node;
        }
    }

    public static void displayList(DLL dll){
        DLLNode temp = dll.head;

        System.out.println(temp);
        while(temp != null){
            System.out.println(temp.prev+" || Data:"+temp.data+ " || "+temp.next);
            temp = temp.next;
        }
    }
}