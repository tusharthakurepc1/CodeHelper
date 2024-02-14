package com.Trie;

import com.Trie.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        String[] wordDict = {};
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        String word = "applepenapple";


        System.out.println(solutionOptimal(word, wordDictSet));

    }

    public static boolean solutionOptimal(String word, HashSet<String> set){
        if(word.length() == 0){
            return true;
        }

        for(int i=1;i<=word.length();i++){
            if(set.contains(word.substring(0, i)) && solutionOptimal(word.substring(i), set)){
                return true;
            }
        }

        return false;
    }

    public static void solutionTrie(String[] wordDict, String word){
        TrieOperations trie = new TrieOperations();
        for(int i=0;i<wordDict.length;i++){
            trie.insert(wordDict[i]);
        }

        int start = 0;
        String buffer = "";

        for(int i=1;i<=word.length();){
            buffer = word.substring(start, i);

            boolean temp = trie.startsWith(buffer);
            System.out.println(temp+ " "+ buffer);
            if(!temp){
                start = i-1;
                buffer = word.substring(start, word.length());
            }

            i++;
        }
        System.out.println(buffer);

        if(trie.search(buffer)) System.out.println("Yes");
        else System.out.println("No");
    }
}
