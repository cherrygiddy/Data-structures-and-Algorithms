package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    public void bubblesort(int[] numbers) {
        boolean isSorted;
        for (var i = 0; i < numbers.length; i++) {
            isSorted = true;
            for (var j = 1; j < numbers.length - 1; j++)
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    public void selectionsSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            var minindex = i;
            for (var j = i; j < numbers.length; j++)
                if (numbers[j] < numbers[minindex]) {
                    minindex = j;
                    swap(numbers, minindex, i);
                }
        }
    }

    private void swap(int[] numbers, int index1, int index2) {
        var tmp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = tmp;
    }

    public void insertionsort(int[] array) {
        for (var i = 1; i < array.length; i++) {
            var current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }

    public void mergesort(int[] array) {
        if (array.length < 2)
            return;
        var middle = array.length / 2;
        int[] left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = array[i];
        int[] right = new int[array.length - middle];
        for (var j = middle; j < array.length; j++)
            right[j - middle] = array[j];
        mergesort(left);
        mergesort(right);
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && k < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else
                result[k++] = right[j++];
        }
        while (i < left.length)
            result[k++] = left[i++];
        while (j < right.length)
            result[k++] = right[j++];
    }

    public void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(int[] array, int start, int end) {
        if (start >= end)
            return;
        var boundary = partitioning(array, start, end);
        quicksort(array, start, boundary - 1);
        quicksort(array, boundary + 1, end);
    }

    private int partitioning(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, i, ++boundary);
        }
        return boundary;
    }
    public void countingsort(int [] array,int max){
        int[] frequencies= new int[max+1];
        for (var item:array)
            frequencies[item]++;
        int k=0;
        for (var i=0;i<frequencies.length;i++){
            for (var j=0;j<frequencies[i];j++){
                array[k++]=i;
            }
        }
    }
    public void bucketsort(int [] array,int numberofbuckets){
        int count=0;
     for (var bucket:creatingBuckets(array,numberofbuckets)){
         Collections.sort(bucket);
         for (var rs:bucket)
             array[count++]=rs;
    }
}
   private List<List<Integer>>creatingBuckets(int [] array,int numberofbuckets){
       List<List<Integer>>buckets=new ArrayList<>();
       for (var i=0;i<numberofbuckets;i++)
           buckets.add(new ArrayList<>());
       for (var item:array)
           buckets.get(item/numberofbuckets).add(item);
       return buckets;
    }
}
