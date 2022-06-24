package com.company;

import java.awt.image.VolatileImage;

public class MinPriorityQueue {
    private MinHeap minHeap= new MinHeap();
    public void  add(String value, int priority){
        minHeap.insert(priority,value);
    }
    public String remove(){
        return minHeap.remove();
    }

}
