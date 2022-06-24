package com.company;

public class Heap {
    int size;
    int [] items = new int[10];
    public void insert(int value){
        if (isFull())
            throw new IllegalArgumentException();
        items[size++]= value;
        bubbleup();
    }
    private void  bubbleup(){
        var index=size-1;
        while (index>0&& items[index]> items[parentIndex(index)]){
            swap(index,parentIndex(index));
            index=parentIndex(index);
        }

    }
    private int parentIndex(int index){
        return (index -1)/2;
    }
    private void swap(int index1,int index2){
        var tmp= items[index1];
        items[index1]= items[index2];
        items[index2]=tmp;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private boolean isFull(){
        return size== items.length;
    }
    public int remove(){
        if (isEmpty())
            throw new IllegalArgumentException();
        var root =items[0];
        items[0]=items[--size];
        bubbldown();
        return root;
    }
    private void  bubbldown(){
        var index=0;
        while (index<=size&&!isvalidparent(index)){
            var largerchild=largerchildindex(index);
            swap(index,largerchild);
            index=largerchild;
        }
    }
    private int leftchildindex(int index){
        return index*2+1;
    }
    private int rightchildindex(int index){
        return index*2+2;
    }
    private int leftchild(int index){
        return items[leftchildindex(index)];
    }
    private int rightchild(int index){
        return items[rightchildindex(index)];
    }
    private boolean isvalidparent(int index){
        if (!hasleftchild(index))
            return true;
        if (!hasrighchild(index))
            return items[index]>=leftchild(index);
        return items[index]>=leftchild(index)&&
                items[index]>=rightchild(index);
    }
    private int largerchildindex(int index){
        if (!hasleftchild(index))
            return index;
        if (!hasrighchild(index))
            return leftchildindex(index);
        return (leftchild(index)>rightchild(index))?leftchildindex(index):rightchildindex(index);
    }
    private boolean hasleftchild(int index){
        return leftchildindex(index)<=size;
    }
    private boolean hasrighchild(int index){
        return rightchildindex(index)<=size;
    }
    public int max(){
        if (isEmpty())
            throw new IllegalArgumentException();
        return items[0];
    }

}
