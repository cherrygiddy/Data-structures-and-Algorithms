package com.company;

import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import javax.swing.plaf.metal.MetalBorders;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class
Main {

    public static void main(String[] args) {
    PriorityQueueArray queue= new PriorityQueueArray();
    queue.insert(5);
    queue.insert(3);
    queue.insert(6);
    while (!queue.isEmpty())
    System.out.println(queue.remove());
    }
    public static int factorial(int n){
        if (n==0)
            return 1;
        return n* factorial(n-1);
    }
    public  static  void  reverse(Queue<Integer>queue){
        //add
        //add
       Stack<Integer>stack= new Stack<>();
       while (!queue.isEmpty())
           stack.push(queue.remove());
        //remove
        while (!stack.isEmpty())
            queue.add(stack.pop());
        //isEmpty
    }

}
