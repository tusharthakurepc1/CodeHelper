package com.LinkedListDataStructure;

public class SingleLinkList {
    public static void main(String[] args) {
        Node head=null;

        head=insertionNodeHead(head,10);
        head=insertionNodeHead(head,20);
        head=insertionNodeHead(head,30);
        head=insertionNodeHead(head,40);
        head=insertionNodeHead(head,50);

        displayLinkedList(head);
    }

    public static Node insertionNodeHead(Node head,int data){
        Node new_node=new Node(data);

        new_node.next=head;
        head=new_node;

        return head;
    }



    public static void displayLinkedList(Node head){
        for(Node temp=head;temp != null;temp=temp.next){
            System.out.println(temp+" "+temp.data+ " "+temp.next);
        }
        System.out.println("***-----***");
    }

}
