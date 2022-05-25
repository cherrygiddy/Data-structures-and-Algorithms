package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tries {
    private class Node{
        private char value;
        private Map<Character,Node>children= new HashMap<>();
        private boolean IsendofWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value='" + value ;
        }
        private  boolean haschild(char ch){
           return children.containsKey(ch);
        }
        private boolean hasChildren(){
           return  !children.isEmpty();
        }
        private void  removechild(char ch){
          children.remove(ch);
        }
        private void  addchild(char ch){
            children.put(ch,new Node(ch));
        }
        private Node  getchild(char ch){
            return children.get(ch);
        }
        private Node[] getchildren(){
            return children.values().toArray(new Node[0]);
        }
    }
    private Node root= new Node(' ');
    public void insert(String word){
        var current = root;
        for (var ch:word.toCharArray()){
            if (current==null)
                return;
            if (!current.haschild(ch))
                current.addchild(ch);
            current=current.getchild(ch);
        }
        current.IsendofWord=true;
    }
    public boolean containsIte(String word){
        var current=root;
        for (var ch:word.toCharArray()) {
            if (!current.haschild(ch))
                return false;
            current = current.getchild(ch);
        }
       return current.IsendofWord;
    }
    public void Traversal(){
        Traversal(root);
    }
    private void Traversal(Node root){
        System.out.println(root.value);
        for (var child:root.getchildren())
            Traversal(child);
    }
    public void  remove(String word){
     if (word==null)
         return;
     remove(root,word,0);
    }
    private void  remove(Node root,String word,int index){
        if (index==word.length()) {
            root.IsendofWord=false;
            return;
        }
        var ch=word.charAt(index);
        var child=root.getchild(ch);
        if (child==null)
            return;
        remove(child,word,index+1);
        if (!root.IsendofWord&&!root.haschild(ch))
            root.removechild(ch);
    }
    public List<String>findwords(String prefix){
        List<String>words= new ArrayList<>();
        var lastNode=lastNode(prefix);
        findwords(lastNode,prefix,words);
        return words;
    }
    private void findwords(Node root,String prefix,List<String>words){
        if (root.IsendofWord)
            words.add(prefix);
        for (var child:root.getchildren())
            findwords(child,prefix+child.value,words);

    }
    private Node lastNode(String prefix){
        var current=root;
        for (var ch:prefix.toCharArray()) {
            var child = current.getchild(ch);
            if (child==null)
                return null;
            current = child;
        }
        return current;
    }
    public boolean containsRec(String word){
        if (word==null)
            return false;
        return containsRec(root,word,0);
    }
    private boolean containsRec(Node root,String word,int index){
        if (index==word.length())
            return root.IsendofWord;
        if (root==null)
            return false;
        var ch=word.charAt(index);
        var child=root.getchild(ch);
        if (child==null)
            return false;
        return containsRec(child,word,index+1);
    }
    public int countWords(){
        return countWords(root);
    }
    private int countWords(Node root){
        int count=0;
        if (root.IsendofWord)
            count++;
        for (var child:root.getchildren())
            count +=countWords(child);
        return count;
    }
    public void print(){
      print(root,"");
    }
    private void print(Node root,String words){
        if (root.IsendofWord)
            System.out.println(words);
        for (var child:root.getchildren())
            print(child,words+child.value);
    }
    public String longestCommonPrefix(String [] words){
        if (words==null)
            return "";
        var trie= new Tries();
        for (var word:words){
            trie.insert(word);
        }
        var prefix=new StringBuffer();
        var current=root;
        var maxchars=shortestWord(words).length();
        while (prefix.length()<maxchars){
            var children=current.getchildren();
            if (children.length!=1)
                break;
            current=children[0];
            prefix.append(current.value);
        }
        return prefix.toString();
    }
    private String shortestWord(String [] words){
        var shortest=words[0];
        for (var i=0;i<words.length;i++){
            if (words[i].length()<shortest.length())
                shortest=words[i];
        }
        return shortest;
    }
}
