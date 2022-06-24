package com.company;

public class MinHeap {
    private class Node{
        private int key;
        private String value;
        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    private Node[]nodes= new Node[10];
    private int size;
    public void insert(int key,String value){
        if (isFull()){
            throw new IllegalArgumentException();
        }
        nodes[size++]= new Node(key,value);
        bubbleup();
    }
    private boolean isFull(){
        return size== nodes.length;
    }
    private int leftchildindex(int index){
        return index*2+1;
    }
    private int rightchildindex(int index){
        return index*2+2;
    }
    private Node leftchild(int index){
        return nodes[leftchildindex(index)];
    }
    private Node rightchild(int index){
        return nodes[rightchildindex(index)];
    }
    private int smallerchildindex(int index){
        if (!hasleftchild(index))
            return index;
        if (!hasrightchild(index))
            return leftchildindex(index);
        return (leftchild(index).key<rightchild(index).key?leftchildindex(index):rightchildindex(index));
    }
    private int largerchildindex(int index){
        return (leftchild(index).key>rightchild(index).key?leftchildindex(index):rightchildindex(index));
    }
    private boolean isvalidparent(int index){
        if (!hasleftchild(index))
            return true;
        if (!hasrightchild(index))
            return nodes[index].key<leftchild(index).key;
        return nodes[index].key<leftchild(index).key&&
                nodes[index].key<rightchild(index).key;

    }
    private boolean hasleftchild(int index){
        return leftchildindex(index)<=size;
    }
    private boolean hasrightchild(int index){
        return rightchildindex(index)<=size;
    }
    private void swap(int index1,int index2){
        var tmp=nodes[index1].key;
        nodes[index1].key=nodes[index2].key;
        nodes[index2].key=tmp;
    }
    private void  bubbleup(){
        int index= size-1;
        while (index>0&&nodes[index].key<nodes[parent(index)].key) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private void bubbledown() {
        int index = 0;
        while (index <= size && !isvalidparent(index)) {
            swap(index, smallerchildindex(index));
            index = smallerchildindex(index);
        }
    }
    public String remove(){
        if (isEmpty())
            throw new IllegalArgumentException();
        var root=nodes[0].value;
        nodes[0]=nodes[--size];
        bubbledown();
        return root;
    }
    private boolean isEmpty(){
        return size==0;
    }
}
