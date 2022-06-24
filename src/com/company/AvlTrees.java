package com.company;

public class AvlTrees {
    private class  AvlNOde{
        private int value;
        private AvlNOde leftchild;
        private AvlNOde rightchild;
        private int height;

        public AvlNOde(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }
    private AvlNOde root;
    public void insert(int value){
     root=insert(root,value);
    }
    private AvlNOde insert(AvlNOde root,int value){
        if (root==null)
            return new AvlNOde(value);
        if (value< root.value) {
            root.leftchild=insert(root.leftchild,value);
        }else {
            root.rightchild=insert(root.rightchild,value);
        }
        setheight(root);
      return balanceit(root);

    }
    private boolean isLeafNode(AvlNOde node){
        return node.leftchild==null||node.rightchild==null;
    }
    public int height(AvlNOde nOde){
        return (nOde==null)?-1:nOde.height;
    }
    private boolean isRightHeavy(AvlNOde node){
        return balancefactor(node)<-1;
    }
    private boolean isLeftHeavy(AvlNOde node){
        return balancefactor(node)>1;
    }
    private int balancefactor(AvlNOde node){
        return (node == null) ? 0 : height(node.leftchild) - height(node.rightchild);
    }
    private void setheight(AvlNOde node){
        node.height= Math.max(height(node.leftchild),height(node.rightchild))+1;
    }
    private AvlNOde balanceit(AvlNOde node) {
        if (isLeftHeavy(node)) {
            if (balancefactor(node.leftchild) < 0)
                node.leftchild = leftrotate(node.leftchild);
            return rightrotate(node);
        } else if (isRightHeavy(node)) {
            if (balancefactor(node.rightchild) > 0)
                node.rightchild = rightrotate(node.rightchild);
            return leftrotate(node);
        }
        return node;
    }
    private AvlNOde leftrotate(AvlNOde node){
        var newroot=node.rightchild;
        node.rightchild=newroot.leftchild;
        newroot.leftchild=root;
        setheight(root);
        setheight(newroot);
        return newroot;
    }
    private AvlNOde rightrotate(AvlNOde node){
        var newroot=node.leftchild;
        node.leftchild=newroot.rightchild;
        newroot.rightchild=root;
        setheight(root);
        setheight(newroot);
        return newroot;
    }
    public boolean isBalanced(){
  return  isBalanced(root);
    }
    private  boolean isBalanced(AvlNOde node){
        if (node==null)
            return true;
  var balancefactor=height(node.leftchild)-height(node.rightchild);
  return Math.abs(balancefactor)<=1&&
          isBalanced(node.leftchild)&&
          isBalanced(node.rightchild);
    }
    public int size(){
        return size(root);
    }
    private int size(AvlNOde node){
        if (root==null)
            throw new IllegalArgumentException();
        if (isLeafNode(node))
            return 1;
        return 1+size(node.leftchild)+size(node.rightchild);
    }
    public boolean isPerfect(){
        return isPerfect(root);
    }
    private boolean isPerfect(AvlNOde node){
        return size()==(Math.pow(2,height(node)+1)-1);
    }
}
