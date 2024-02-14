package com.LinkedListDataStructure;


public class Node{
    int data;
    Node next;
    Node(){
        this.data=0;
        this.next=null;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class NodeRandom extends Node{
    NodeRandom next;
    NodeRandom random;
    NodeRandom(){
        super();
        random=null;
    }

    NodeRandom(int data){
        super(data);
        random=null;
    }
}

class DLLNode{
    int data;
    DLLNode prev;
    DLLNode next;
    DLLNode(){
        data = 0;
        prev = next = null;
    }

    DLLNode(int data){
        this.data = data;
        prev = next = null;
    }
}

class DLL{
    DLLNode head = new DLLNode();
    DLLNode tail = new DLLNode();
    DLL(){
        this.head = null;
        this.tail = null;
    }
}

class LRUNode{
    int key;
    int value;
    LRUNode prev,next;

    LRUNode(){
        key = value = 0;
        prev = next = null;
    }
    LRUNode(int key, int value){
        this.key = key;
        this.value = value;
        prev = next = null;
    }
}

class Pointers{
    LRUNode head;
    LRUNode tail;

    Pointers(){
        head = tail =null;
    }
}

class PointersUpdated{
    LRUNode head;
    LRUNode tail;

    PointersUpdated(){
        head = new LRUNode(-1,-1);
        tail = new LRUNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
}