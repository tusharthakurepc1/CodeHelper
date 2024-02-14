package com.LinkedListDataStructure;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CacheLRUDoubleLinkedListM2 {

    public static void main(String[] args) {
        PointersUpdated pointers = new PointersUpdated();
        Map<Integer,LRUNode> map = new HashMap<>();
        int size = 3;

        size = putLRUCache(pointers,map,1,1,size);
        size = putLRUCache(pointers,map,2,2,size);
        size = putLRUCache(pointers,map,3,3,size);
        size = putLRUCache(pointers,map,4,4,size);
        System.out.println("Get: "+getLRUCache(pointers,map,4,size));
        System.out.println("Get: "+getLRUCache(pointers,map,3,size));
        System.out.println("Get: "+getLRUCache(pointers,map,2,size));
        System.out.println("Get: "+getLRUCache(pointers,map,1,size));
        size = putLRUCache(pointers,map,5,5,size);
        System.out.println("Get: "+getLRUCache(pointers,map,1,size));
        System.out.println("Get: "+getLRUCache(pointers,map,2,size));
        System.out.println("Get: "+getLRUCache(pointers,map,3,size));
        System.out.println("Get: "+getLRUCache(pointers,map,4,size));
        System.out.println("Get: "+getLRUCache(pointers,map,5,size));

        displayList(pointers);
        System.out.println(map);
    }

    public static int putLRUCache(PointersUpdated pointers,Map<Integer,LRUNode> map,int key,int value,int size){
        LRUNode new_node = new LRUNode(key,value);
        if(map.isEmpty()){
            insertionStart(pointers,new_node);
            map.put(key,new_node);
            size--;
        }
        else if(!map.isEmpty() && !map.containsKey(key)){
            if(size > 0){
                insertionStart(pointers, new_node);
                map.put(key, new_node);
            }
            else{
                LRUNode delete = pointers.tail.prev;
                deleteNode(pointers, delete);

                map.remove(delete.key);
                insertionStart(pointers, new_node);
                map.put(key, new_node);
            }
            size --;
        }
        else if(!map.isEmpty() && map.containsKey(key)){
            LRUNode delete = map.get(key);
            deleteNode(pointers, delete);

            map.remove(key);
            insertionStart(pointers, new_node);
            map.put(key, new_node);
        }

        return size;
    }

    public static int getLRUCache(PointersUpdated pointers,Map<Integer,LRUNode> map,int key,int size){
        if(map.containsKey(key)){
            LRUNode find = map.get(key);

            deleteNode(pointers, find);
            insertionStart(pointers, find);
            return find.value;
        }
        return -1;
    }

    public static void insertionStart(PointersUpdated pointers,LRUNode new_node){
        LRUNode temp = pointers.head;
        temp = temp.next;

        pointers.head.next = new_node;
        new_node.next = temp;
        temp.prev = new_node;
        new_node.prev = pointers.head;
    }

    public static void deleteNode(PointersUpdated pointers,LRUNode delete){
        LRUNode prev = delete.prev;
        LRUNode next = delete.next;

        prev.next = next;
        next.prev = prev;
    }

    public static void displayList(PointersUpdated pointer){
        LRUNode temp = pointer.head;
        temp = temp.next;
        System.out.println(pointer.head);
        while(temp != pointer.tail){
            System.out.println(temp+" "+temp.key+"=>"+temp.value+" "+temp.next);

            temp = temp.next;
        }
        System.out.println(pointer.tail);
    }
}
