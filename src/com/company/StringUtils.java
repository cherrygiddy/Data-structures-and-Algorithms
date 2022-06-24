package com.company;

import java.util.*;

public class StringUtils {
    public static int countvowels(String word) {
        String vowels = "aeiou";
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (var ch : word.toLowerCase().toCharArray()) {
            if (vowels.contains(Character.toString(ch)))
                count++;
        }
        return count;
    }

    public static String reverseString(String word) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (var ch : word.toCharArray()) {
            stack.push(ch);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static String reverseWords(String sentence) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        String[] words = sentence.split(" ");
        for (var i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop() + " ");
        }
        return builder.toString().trim();
    }

    public static boolean rotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        if (str1.toUpperCase().length() != str2.toUpperCase().length())
            return false;
        String cog = str1 + str1;
        if (cog.toUpperCase().contains(str2))
            return true;
        return false;
    }

    public static String removeduplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (var ch : str.toCharArray())
            if (!set.contains(ch)) {
                set.add(ch);
                builder.append(ch);
            }
        return builder.toString();
    }

    public static char mosreapetd(String str) {
        final int ASCII_SIZE = 256;
        int[] frequences = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequences[ch]++;
        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequences.length; i++)
            if (frequences[i] > max) {
                max = frequences[i];
                result = (char) i;
            }
        return result;
    }

    public static char repeatedMOst(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : str.toCharArray()) {
            if (map.containsKey(ch))
                map.replace(ch, map.get(ch + 1));
            map.put(ch, 1);
            int max = 0;
            char result = ' ';
            for (var rs : str.toCharArray()) {
                if (map.get(rs) > max) {
                    max = map.get(rs);
                    // result = (char) map.keySet();
                }
            }
        }
        return 0;
    }

    public static String capitilization(String sentence) {
        String[] words = sentence.split(" ");
        for (var ch=0;ch<words.length;ch++) {
            words[ch] = words[ch].substring(0, 1).toUpperCase() + words[ch].substring(1).toLowerCase();
        }
            return String.join(" ", words);
    }
    public static void anagram(String str1,String str2){
        //if (str1.length()!=str2.length())
           // return false;
        var array1= str1.toCharArray();
       // Arrays.sort(array1);
        var array2=str2.toCharArray();
       // Arrays.sort(array2);

       //return Arrays.equals(array1,array2);
    }
  public static  boolean ispalidrom(String word){
        var output=new StringBuilder(word);
        output.reverse();
        return output.toString().equals(word);
  }
  public static  boolean palidrome(String word){
        int left=0;
        int right=word.length()-1;
        while (left<right) {
            if (word.charAt(left++) != word.charAt(right--))
                return false;
        }
        return true;
  }
}
