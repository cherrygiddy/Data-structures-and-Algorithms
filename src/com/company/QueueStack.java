package com.company;

import java.util.Stack;

public class QueueStack {
    Stack<Integer>stack= new Stack<>();
    Stack<Integer>stack1= new Stack<>();
    public void add(int item){
        stack.push(item);
    }

    @Override
    public String toString() {
        return "stack=" + stack;
    }
    public int  deque(){
        Movestack1tostack2();
        return stack1.pop();
        }

    private void Movestack1tostack2() {
        if (stack1.isEmpty()){
            while (!stack.isEmpty()){
                    stack1.push(stack.pop());
                }
            }
    }
}
