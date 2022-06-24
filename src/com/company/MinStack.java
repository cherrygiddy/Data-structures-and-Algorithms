package com.company;

import java.util.Stack;

public class MinStack {
    private Stack<Integer>stack= new Stack<>();
    private Stack<Integer>minstack= new Stack<>();

    public void  push(int item){
        stack.push(item);
        if (minstack.isEmpty())
            minstack.push(item);
        else if (item<minstack.peek())
            minstack.push(item);
    }
    private int min(){
        return minstack.peek();
    }
}
