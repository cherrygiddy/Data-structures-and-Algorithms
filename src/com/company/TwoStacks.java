package com.company;

import java.util.Arrays;

public class TwoStacks {
    private int top1;
    private int top2;
    private int[] items;

    public TwoStacks(int capacity) {
        if (capacity<=0)
            throw new IllegalArgumentException("capacity must be greater than 0");
        items=new int[capacity];
        top1=-1;
        top2=capacity;
    }
    public void  push1(int item){
        if (isfull1())
            throw new IllegalArgumentException();
        items[++top1]=item;
    }
    private boolean isfull1(){
        return top1+1==top2;
    }
    private boolean isfull2(){
        return top2==top1+1;
    }
    public void push2(int item){
        if (isfull2())
            throw new IllegalArgumentException();
        items[--top2]=item;
    }
    private boolean isEmpty1(){
        return top1==-1;
    }
    private boolean isEmpty2(){
        return top2==items.length;
    }
    public int pop1(){
        if (isEmpty1())
            throw new IllegalArgumentException();
        return items[--top1];
    }
    public int pop2(){
        if (isEmpty2()) {
            throw new IllegalArgumentException();
        }
        return items[top2++];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
