package com.company;

import java.util.ArrayList;

public class Tree {
    private  class  Node{
        private int value;
        private Node leftchild;
        private  Node rightchild;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node="+ value ;
        }
    }
    private Node root;
    public void insert(int value){
     if (root==null) {
         root = new Node(value);
         return;
     }
     var current=root;
    while (true){
        if (value<current.value){
            if (current.leftchild==null) {
                current.leftchild = new Node(value);
                break;
            }
            current=current.leftchild;
        }
        else{
            if (current.rightchild==null){
                current.rightchild= new Node(value);
                break;
            }
            current=current.rightchild;
        }
    }
    }
    public boolean contains(int value){
        return contains(root,value);
    }
    private boolean contains(Node root,int value){
        if (isEmpty())
            return false;
        var current=root;
        while (current!=null) {
            if (value < current.value)
                current = current.leftchild;
            else if (value > current.value)
                current = current.rightchild;
            else
                return true;
        }
        return false;
        }
    private  boolean isEmpty(){
        return root==null;
    }
    public void  traversal(){
        traversal(root);
    }
    private  void  traversal(Node root){
        if (root==null)
            return;
        System.out.println(root.value);
        traversal(root.leftchild);
        traversal(root.rightchild);
    }
  public int height(){
      if (root==null)
          throw new IllegalArgumentException();
        return height(root);
  }
  private int height(Node root){
      if (root==null)
          return -1;
        if (isLeafNode(root))
            return 0;
        return 1+Math.max(height(root.leftchild),height(root.rightchild));
  }
  private boolean isLeafNode(Node node){
        return node.leftchild==null&&node.rightchild==null;
  }
  public int min(){
        if (root==null)
            throw new IllegalArgumentException();
       var current=root;
       var last =current;
       while (current!=null) {
           last = current;
           current = current.leftchild;
       }
       return last.value;
  }
  private int min(Node node){
       if (isLeafNode(node))
           return node.value;
       var left =min(node.leftchild);
       var right=min(node.rightchild);
       return Math.min(Math.min(left,right),node.value);
  }
  public boolean equals(Tree other){
   return  equals(root,other.root);
  }
  private boolean equals(Node first,Node second){
      if (first==null&&second==null){
          return  true;
      }
      if (first!=null&&second!=null)
          return first.value==second.value&&
                  equals(first.leftchild,second.leftchild)&&
                  equals(first.rightchild,second.rightchild);
      return false;

  }
  public boolean isBst(){
        return isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }
  private boolean isBst(Node root,int min,int max){
        if (root==null)
            return true;
        if (root.value<min||
            root.value>max)
            return false;
        return isBst(root.leftchild,min,root.value-1)&&
              isBst(root.rightchild,root.value+1,max);
  }
  public void swap(){
        swap(root.leftchild,root.rightchild);
  }
  private void  swap(Node left,Node right){
        var tmp=left.value;
        left.value= right.value;
        right.value=tmp;
  }
  public ArrayList<Integer> NodesatDistance(int k){
      ArrayList<Integer>list= new ArrayList<>();
     NodesatDistance(root,k,list);
     return list;
  }
  private void NodesatDistance(Node root,int k,ArrayList<Integer>list){
        if (root==null)
           return;
        if (k==0) {
           list.add(root.value);
            return;
        }
        NodesatDistance(root.leftchild,k-1,list);
        NodesatDistance(root.rightchild,k-1,list);
  }
  public void traverseLevelOrder(){
        for (var i=0;i<=height();i++){
            for (var value:NodesatDistance(i))
                System.out.println(value);
        }
  }
  public  int size(){
        return size(root);
  }
  private int size(Node root){
        if (root==null)
            return 0;
        if (isLeafNode(root))
            return 1;
        return size(root.leftchild)+size(root.rightchild);
  }
  public int max(){
    return max(root);
  }
  private int max(Node root){
        if (root.rightchild==null)
            return root.value;
        return max(root.rightchild);
  }
  public boolean containsRe(int value){
        return contains(root,value);
  }
  private boolean containsRe(Node root,int value){
       if (root==null)
           return true;
       if (isLeafNode(root))
           return false;
       while (root!=null) {
           if (root.value == value)
               return true;
           contains(root.leftchild, value);
           contains(root.rightchild, value);
       }
       return false;
  }
  public boolean areSibling(int a,int b){
   return areSibling(root,a,b);
  }
  private boolean areSibling(Node root,int a,int b){
      var aresiblings=false;
      if (root.leftchild!=null||root.rightchild!=null) {
          aresiblings = (root.leftchild.value == a && root.rightchild.value == b) ||
                  (root.leftchild.value == b && root.rightchild.value == a);
      }
          return aresiblings ||
                  areSibling(root.leftchild,a,b)||
                  areSibling(root.rightchild,a,b);
      }
      public  ArrayList<Integer> getAncestors(int value){
       ArrayList<Integer>list=new ArrayList<>();
       var rs= getAncestors(root,value,list);
       return  list;
      }
      private boolean getAncestors(Node root,int value,ArrayList<Integer>list) {
          if (root == null)
              return false;
          if (root.value == value)
              return true;
          if (getAncestors(root.leftchild, value, list) ||
                  getAncestors(root.rightchild, value, list)){
              list.add(root.value);
          return true;
      }
          return false;
      }
      public boolean isbalanced(){
   return isbalanced(root);
      }
      private boolean isbalanced(Node root){
        if (root==null)
            return true;
        var balanceFactor=height(root.leftchild)-height(root.rightchild);
        return Math.abs(balanceFactor)<=1&&
                isbalanced(root.leftchild)&&
                isbalanced(root.rightchild);
      }
    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }
}
