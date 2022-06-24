package com.company;

import java.util.Arrays;

public class CircularArrays {
    private int [] items= new int[5];
     int size=0;
     int front;
     int rear;
     public void add(int item){
         if (isfull()){
             throw new IllegalArgumentException();
         }
         items[rear]=item;
         rear=(rear+1)%items.length;
         size++;
     }
     private boolean isfull(){
         return size== items.length;
     }
     private boolean isEmpty(){
         return size==0;
     }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    public void dequeque(){
         items[front]=0;
         front=(front+1)%items.length;
         size--;
    }
}
