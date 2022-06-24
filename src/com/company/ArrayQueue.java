package com.company;

import java.util.Arrays;

public class ArrayQueue {
    int [] items =new int[5];
    int size=0;
    private int front;
    private int rear;
    public void add(int item){
        if (isFull())
            throw new IllegalArgumentException();
        items[rear++]=item;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    public int dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        var item=items[front];
        items[front++]=0;
        size--;
        return item;
    }
    private boolean isFull(){
        return size== items.length;
    }
    private boolean isEmpty(){
        return size==0;
    }
}
