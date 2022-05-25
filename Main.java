package com.company;

import java.awt.event.MouseAdapter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class
Main {

    public static void main(String[] args) {
        int [] numbers={1,9,10,52,16};
        var pq= new PQwithHeap();
        for (var num:numbers)
        pq.insert(num);
        System.out.println(pq);
    }
}
