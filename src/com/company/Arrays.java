package com.company;

public class Arrays {
    private int[] items= new int[5];
    private int size;
    public void insert(int item){
            if (isFull()) {
                int[] newarray = new int[size * 2];
                for (int i = 0; i < items.length; i++) {
                    newarray[i] = items[i];
                }
                    items = newarray;
            }
        items[size++]=item;
    }
    private boolean isFull(){
        return  items.length==size;
    }
    public void print(){
        for (var i=0;i<size;i++){
            System.out.println(items[i]);
        }
    }
    private boolean isEmpty(){
        return size==0;
    }
    public void remove(int index){
        if (isEmpty())
            throw new IllegalArgumentException();
        if (index<0||index>=size)
            throw new IllegalArgumentException();
        for (var i=index;i<size;i++){
           items[i]=items[i+1];
        }
        size--;
    }
    public int indexof(int item){
        for (var i=0;i<items.length;i++)
            if (items[i]==item)
                return i;
        return -1;
    }
    public int max(){
        int max=0;
        for (var i=0;i<size;i++){
            if (items[i]<max)
                max=items[i];
        }
        return max;
    }
    public int intersect(int [] otherArray){
        for (var i=0;i<size;i++){
            for (var j=0;j<otherArray.length;j++){
                if (items[i]==otherArray[j])
                    return items[i];
            }
        }
        return -1;
    }
    public void  reverse(int [] array){
        for (var i=array.length-1;i>=0;i--){
            System.out.println(array[i]);
        }
    }
    public void  insertAt(int item, int index){

    }
}
