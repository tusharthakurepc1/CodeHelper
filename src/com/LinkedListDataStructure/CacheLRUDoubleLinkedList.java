package com.LinkedListDataStructure;

import com.LinkedListDataStructure.*;

import java.util.HashMap;
import java.util.Map;



public class CacheLRUDoubleLinkedList {
    public static void main(String[] args) {
        Pointers pointers = new Pointers();
        Map<Integer, LRUNode> map = new HashMap<>();
        int size = 3;

        size = putCacheLRU(pointers,map,1,1,size);
        size = putCacheLRU(pointers,map,2,2,size);
        size = putCacheLRU(pointers,map,3,3,size);
        size = putCacheLRU(pointers,map,4,4,size);
        System.out.println("Get: "+getCacheLRU(pointers,map,4,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,3,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,2,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,1,size));
        size = putCacheLRU(pointers,map,5,5,size);
        System.out.println("Get: "+getCacheLRU(pointers,map,1,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,2,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,3,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,4,size));
        System.out.println("Get: "+getCacheLRU(pointers,map,5,size));

        displayList(pointers);
        System.out.println("Map"+map);
    }


    public static int putCacheLRU(Pointers pointers,Map<Integer,LRUNode> map,int key,int value,int size){
        LRUNode new_node = new LRUNode(key,value);

        if(map.isEmpty() && pointers.head == null && pointers.tail == null){
            pointers.head = pointers.tail = new_node;
            map.put(key, new_node);
            size--;
        }
        else if(!map.isEmpty() && map.containsKey(key)){
            //Remove last node and insert new node at the front.
            deleteNode(pointers,map.get(key));
            if(pointers.tail != null && map.containsKey(key)) {
                map.remove(key);
            }

            insertStart(pointers,new_node);
            map.put(key,new_node);
        }
        else if(!map.isEmpty()){
            if(size > 0){
                //Insert in front..
                LRUNode temp = pointers.head;

                pointers.head = new_node;
                new_node.next = temp;
                temp.prev = new_node;

                map.put(key,new_node);
                size--;
            }
            else{
                //Remove last node and insert new node at the front.
                if(pointers.tail != null && map.containsKey(pointers.tail.key))
                    map.remove(pointers.tail.key);
                deleteNode(pointers,pointers.tail);

                insertStart(pointers,new_node);
                map.put(key,new_node);
            }
        }
        return size;
    }

    public static void deleteNode(Pointers pointers,LRUNode delete){
        if(pointers.head == null || pointers.tail == null){
            return;
        }
        else if(pointers.head == pointers.tail){
//            System.out.println("Having one node");
            pointers.head = pointers.tail = null;
        }
        else if(delete == pointers.tail){
            LRUNode temp = delete;

            temp = temp.prev;
            pointers.tail = temp;
            temp.next = null;
        }
        else if(delete == pointers.head){
            LRUNode temp = delete;

            temp = temp.next;
            pointers.head = temp;
            temp.prev = null;
        }
        else{
            LRUNode temp = delete;

            temp = temp.prev;
            temp.next = delete.next;
            delete.next.prev = temp;
        }

    }

    public static void insertStart(Pointers pointers,LRUNode new_node){
        if(pointers.head == null || pointers.tail == null){
            pointers.head = pointers.tail = new_node;
        }
        else{
            LRUNode temp = pointers.head;

            pointers.head = new_node;
            new_node.next = temp;
            temp.prev = new_node;

            new_node.prev = null;
        }
    }

    public static int getCacheLRU(Pointers pointers,Map<Integer,LRUNode> map,int key,int size){
        if(pointers.head == null || map.isEmpty()){
            return -1;
        }
        else if(map.containsKey(key)){
            if(pointers.head == pointers.tail){
                System.out.println("Only one node GET--");
                int value = map.get(key).value;
                return value;
            }

            int value = map.get(key).value;
            LRUNode new_node = map.get(key);
            deleteNode(pointers, map.get(key));

            insertStart(pointers,new_node);
            return value;
        }
        return -1;
    }



    public static void displayList(Pointers pointers){
        LRUNode temp = pointers.head;

        System.out.println(pointers.head);
        while(temp != null){
            System.out.println(temp+" "+temp.key+"=>"+temp.value+" "+temp.next);
            temp = temp.next;
        }
        System.out.println(pointers.tail);
    }
}