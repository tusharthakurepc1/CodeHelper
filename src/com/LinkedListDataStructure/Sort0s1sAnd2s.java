package com.LinkedListDataStructure;

public class Sort0s1sAnd2s {
    public static void main(String[] args) {
        Node n5 = new Node(0);
        Node n4 = new Node(0);     n4.next = n5;
        Node n3 = new Node(0);     n3.next = n4;
        Node n2 = new Node(0);     n2.next = n3;
        Node n1 = new Node(0);     n1.next = n2;
        Node head = n1;


        displayLL(sort(head));

    }

    public static Node sort(Node head){
        Node temp = head;
        Node zero_head = new Node(-1), zero = zero_head;
        Node one_head = new Node(-1), one = one_head;
        Node two_head = new Node(-1), two = two_head;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else if(temp.data == 2){
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }
        
        if(one_head.next != null){
            zero.next = one_head.next;
            one.next = two_head.next;
        }
        else{
            zero.next = two_head.next;
        }
        two.next = null;

        return zero_head.next;
    }

    public static void displayLL(Node head){
        Node temp = head;

        System.out.println("HEAD: "+head);
        while(temp != null){
            System.out.println(temp.data+" "+temp);
            temp = temp.next;
        }
    }

}
