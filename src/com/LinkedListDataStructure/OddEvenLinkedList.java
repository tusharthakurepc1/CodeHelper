package com.LinkedListDataStructure;

public class OddEvenLinkedList {
    public static void main(String[] args) {
//        Node n6 = new Node(60);
        Node n5 = new Node(50);
        Node n4 = new Node(40);     n4.next = n5;
        Node n3 = new Node(30);     n3.next = n4;
        Node n2 = new Node(20);     n2.next = n3;
        Node n1 = new Node(10);     n1.next = n2;
        Node head = n1;


//        displayLL(oddEven(head));

        displayLL(oddEvenOptimal(head));
    }

    public static Node oddEvenOptimal(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node even = head.next, even_head = head.next, odd = head;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            odd.next = even_head;
            even = even.next;
        }

        return head;
    }

    public static Node oddEven(Node head){
        Node even_list = new Node(-1), even = even_list;
        Node odd_list = new Node(-1), odd = odd_list;
        Node temp = head;

        int counter = 1;
        while(temp != null){
            if(counter % 2 == 0){
//                Even List
                Node new_node = new Node(temp.data);
                even.next = new_node;
                even = even.next;
            }
            else{
//                Odd List
                Node new_node = new Node(temp.data);
                odd.next = new_node;
                odd = odd.next;
            }
            counter+=1;
            temp = temp.next;
        }

        odd = odd_list;

        while(odd.next != null && odd != null){
            odd = odd.next;
        }

        odd.next = even_list.next;

        return odd_list.next;
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
