package com.Trie;

public class TrieNode {
    TrieNode ds[];
    boolean isEnd;

    TrieNode(){
        ds = new TrieNode[26];
        isEnd = false;
    }
}
