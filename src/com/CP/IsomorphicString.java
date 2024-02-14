package com.CP;

import java.util.*;

public class IsomorphicString {
    public static void main(String[] args) {
        String s1 = "paper", s2 = "title";

        System.out.println(isomorphicString(s1, s2));
    }

    public static boolean isomorphicString(String s1, String s2){
        Map<Character, Integer> m1 = new TreeMap<>();
        Map<Character, Integer> m2 = new TreeMap<>();

        for(int i=0;i<s1.length();i++){
            if(!m1.containsKey(s1.charAt(i))){
                m1.put(s1.charAt(i), 1);
            }
            else{
                m1.put(s1.charAt(i), m1.get(s1.charAt(i))+1);
            }
        }
        for(int i=0;i<s2.length();i++){
            if(!m2.containsKey(s2.charAt(i))){
                m2.put(s2.charAt(i), 1);
            }
            else{
                m2.put(s2.charAt(i), m2.get(s2.charAt(i))+1);
            }
        }

        Collection<Integer> freq1 = m1.values();
        Collection<Integer> freq2 = m2.values();
        System.out.println(freq1 +" "+m1);
        System.out.println(freq2 +" "+m2);

        if(freq1.size() != freq2.size() || !freq1.equals(freq2)){
            return false;
        }

        return true;

    }
}
