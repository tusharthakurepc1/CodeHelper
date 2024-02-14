package com.LinkedListDataStructure;

import java.util.HashMap;

public class CopyListRandomPointers {
    public static void main(String[] args) {
        NodeRandom node4=new NodeRandom(40);    node4.next=null;    node4.random=node4;
        NodeRandom node3=new NodeRandom(30);    node3.next=node4;   node3.random=null;
        NodeRandom node2=new NodeRandom(20);    node2.next=node3;
        NodeRandom node1=new NodeRandom(10);    node1.next=node2;   node1.random=node3;
        NodeRandom headOriginal=node1;
        node2.random=node1;


//        bruteForce(headOriginal);
        optimalSolution(headOriginal);


        displayList(headOriginal);
    }

    public static void bruteForce(NodeRandom head){
        HashMap<NodeRandom,NodeRandom> map=new HashMap<>();

        NodeRandom temp=head;

        while(temp != null){
            NodeRandom new_node=new NodeRandom(temp.data);
            map.put(temp,new_node);
            temp=temp.next;
        }

        System.out.println(map);

        temp=head;

        while(temp != null){
            NodeRandom curr=map.get(temp);
            if(map.containsKey(temp)){
                NodeRandom point_next=temp.next;
                NodeRandom point=temp.random;

                NodeRandom update_node=map.get(temp);

                if(point_next == null){
                    update_node.next=null;
                }
                else{
                    update_node.next=map.get(point_next);
                }

                if(point == null){
                    update_node.random=null;
                }
                else{
                    update_node.random=map.get(point);
                }

            }

            temp=temp.next;
        }

        NodeRandom head_new=map.get(head);



    }

    public static void optimalSolution(NodeRandom head){

//        Create Node at the middle of original list
        NodeRandom temp=head;
        while(temp != null){
            NodeRandom new_node=new NodeRandom(temp.data);

            NodeRandom next_nd=null;
            if(temp.next != null)   next_nd=temp.next;

            temp.next=new_node;
            new_node.next=next_nd;

            temp=temp.next.next;
        }
//        Update the random node;

        temp=head;
        while(temp != null){
            if(temp.random == null){
                temp.next.random=null;
            }
            else{
                temp.next.random=temp.random.next;
            }

            temp=temp.next.next;
        }
//    Separate the copy and the original list

        temp=head;
        NodeRandom copy_head=head.next;

        NodeRandom copy_temp=temp.next;
        while(temp != null){
            temp.next=copy_temp.next;
            temp=temp.next;
            if(temp != null){
                copy_temp.next=temp.next;
            }
            copy_temp=copy_temp.next;
        }



        displayList(head);
        displayList(copy_head);
    }





    public static void displayList(NodeRandom head){
        NodeRandom temp=head;
//        System.out.println(head);
        System.out.println("--------------------------------------------------");
        while(temp != null){
            System.out.println(temp+" => "+temp.data+" NEXT::"+temp.next+" RAND::"+temp.random);
            temp=temp.next;
        }
    }
}
