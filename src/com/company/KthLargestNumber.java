package com.company;

public class KthLargestNumber {
    private Heap heap= new Heap();
    public int Kthlargeetst(int [] array,int k){
        if (k<1||k>array.length)
            throw new IllegalArgumentException();
        for (var numb:array)
            heap.insert(numb);
        for (var i =0;i<k-1;i++)
           heap.remove();
        return heap.max();
    }
}
