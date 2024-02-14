package com.LinkedListDataStructure;

public class InsertionSortList {
    public static void main(String[] args) {
        Node head=null;
        head=SingleLinkList.insertionNodeHead(head,0);
        head=SingleLinkList.insertionNodeHead(head,4);
        head=SingleLinkList.insertionNodeHead(head,3);
        head=SingleLinkList.insertionNodeHead(head,5);
        head=SingleLinkList.insertionNodeHead(head,-1);


//        SingleLinkList.displayLinkedList(head);

        insertionSort(head);
    }

    public static void insertionSort(Node head){
        Node sorted=new Node(Integer.MIN_VALUE);

        Node temp=head;

        while (temp != null){
            Node prev=sorted,iter_curr=prev.next;
            int data = temp.data;

            if(iter_curr == null){
                prev.next=temp;

                iter_curr = temp;
                temp = temp.next;

                iter_curr.next=null;
            }
            else{
                while(iter_curr != null && data > iter_curr.data){
                    prev = iter_curr;
                    iter_curr = iter_curr.next;
                }


                if(iter_curr == null){
                    prev.next = temp;
                    iter_curr = null;
                }
                else{
                    prev.next = temp;
                }
                temp = temp.next;
                prev.next.next = iter_curr;

            }
        }
        sorted = sorted.next;

        SingleLinkList.displayLinkedList(sorted);
    }

    public static void insertionSortM2(Node head){
        Node sorted=new Node(Integer.MIN_VALUE);
        Node temp=head;

        while (temp != null){
            Node prev=sorted,iter_curr=prev.next;
            int data = temp.data;

            while(iter_curr != null && data > iter_curr.data){
                prev = iter_curr;
                iter_curr = iter_curr.next;
            }

            if(iter_curr == null){
                prev.next = temp;
                iter_curr = null;
            }
            else{
                prev.next = temp;
            }
            temp = temp.next;
            prev.next.next = iter_curr;

        }
        sorted = sorted.next;

        SingleLinkList.displayLinkedList(sorted);
    }

}
