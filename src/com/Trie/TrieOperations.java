package com.Trie;

public class TrieOperations {
    TrieNode head = null;
    TrieOperations(){
        head = new TrieNode();
    }

    public void insert(String str){
        TrieNode temp = head;

        for(int i=0;i<str.length();i++){
//            System.out.println();
            if(temp.ds[(int)(str.charAt(i) - 'a')] == null){
                temp.ds[(int)(str.charAt(i) - 'a')] = new TrieNode();
            }

            temp = temp.ds[(int)(str.charAt(i) - 'a')];
        }

        temp.isEnd = true;
    }

    public boolean search(String str){
        TrieNode temp = head;

        for(int i=0;i<str.length();i++){

            if (temp.ds[(int) (str.charAt(i) - 'a')] == null) {
                return false;
            }

            temp = temp.ds[(int)(str.charAt(i) - 'a')];
        }

        return temp.isEnd;
    }

    public boolean startsWith(String str){
        TrieNode temp = head;

        for(int i=0;i<str.length();i++){

            if(temp.ds[(int)(str.charAt(i) - 'a')] == null){
                return false;
            }

            temp = temp.ds[(int)(str.charAt(i) - 'a')];
        }

        if(temp != null)    return true;
        else    return false;
    }

    public static void main(String[] args) {
        TrieOperations o1 = new TrieOperations();
        o1.insert("abcde");

        System.out.println(o1.startsWith("abcd"));
    }
}
