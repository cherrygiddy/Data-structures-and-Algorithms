package com.company;

public class PQwithHeap {
    private Heap heap= new Heap();
    public void insert(int item){
        heap.insert(item);
    }
    public void remove(int item){
         heap.remove();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
