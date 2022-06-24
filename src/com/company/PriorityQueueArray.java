package com.company;

import java.util.Arrays;

public class PriorityQueueArray {
    private  int[] items= new int[5];
    private int size;
    public void insert(int item){
        int i;
        i = shiftitemstoinsert(item);
        items[i+1]=item;
        size++;
    }

    private int shiftitemstoinsert(int item) {
        int i;
        for (i=size-1; i>=0; i--){
            if (items[i]> item)
                items[i+1]=items[i];
            else
                break;
        }
        return i;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int  remove(){
        if (isEmpty())
            throw new IllegalArgumentException();
        return items[--size];
    }
}
