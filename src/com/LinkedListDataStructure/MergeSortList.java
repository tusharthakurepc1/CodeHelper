package com.LinkedListDataStructure;

import com.LinkedListDataStructure.*;

public class MergeSortList {
    public static void main(String[] args) {
        Node head=null;

        head=SingleLinkList.insertionNodeHead(head,40);
        head=SingleLinkList.insertionNodeHead(head,39);
        head=SingleLinkList.insertionNodeHead(head,10);
        head=SingleLinkList.insertionNodeHead(head,62);
        head=SingleLinkList.insertionNodeHead(head,93);

        head=mergeSort(head);


        SingleLinkList.displayLinkedList(head);
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            SingleLinkList.displayLinkedList(head);
            return head;
        }

        Node midNode=middleElement(head);

        Node right_list=midNode.next;
        Node left_list=head;
        midNode.next=null;

        left_list=mergeSort(left_list);       //Left List Recc Call.
        right_list=mergeSort(right_list);      //Right List Recc Call.

        return mergeList(left_list,right_list);
    }

    public static Node mergeList(Node head1,Node head2){
        Node list1=head1,list2=head2;
        Node res=new Node(-1);
        Node res_iter=res;

        if(head1 == null)   return head2;
        if(head2 == null)   return head1;

        while(list1 != null && list2 != null){

            if(list1.data <= list2.data){
                res_iter.next=list1;
                res_iter=res_iter.next;

                list1=list1.next;
            }
            else{
                res_iter.next=list2;
                res_iter=res_iter.next;

                list2=list2.next;
            }
        }

        while(list1 != null){
            res_iter.next=list1;
            res_iter=res_iter.next;

            list1=list1.next;
        }

        while(list2 != null){
            res_iter.next=list2;
            res_iter=res_iter.next;

            list2=list2.next;
        }

        res=res.next;
        return res;
    }

    public static Node middleElement(Node head){
        Node slow=head,fast=head;
        Node prev=null;
        while(fast != null && fast.next != null){
//            System.out.println(slow.data+"  "+fast.data);
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        return prev;
    }

    public static int getLengthList(Node head){
        Node temp=head;
        int len=0;
        while(temp != null){
            len++;
            temp=temp.next;
        }
        return len;
    }
}
