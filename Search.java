package com.company;

public class Search {
    public int linearSearch(int[] numbers, int item) {
        if (numbers == null)
            throw new IllegalArgumentException();
        for (var i = 0; i < numbers.length; i++)
            if (numbers[i] == item)
                return i;
        return -1;
    }

    public int binarysearch(int[] numbers, int item) {
        if (numbers == null)
            throw new IllegalArgumentException();
        return binarysearch(numbers, item, 0, numbers.length - 1);
    }

    private int binarysearch(int[] numbers, int item, int left, int right) {
        if (left > right)
            return -1;
        var middle = (left + right) / 2;
        if (numbers[middle] == item)
            return middle;
        if (item<numbers[middle])
            return binarysearch(numbers, item, left, middle - 1);
        return binarysearch(numbers, item, middle + 1, right);
    }

    public int binarysearchIte(int[] numbers, int item) {
        int left = 0;
        int right = numbers.length / 2;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (numbers[middle] == item)
                return middle;
            if (item < numbers[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public int ternarySearch(int[] numbers, int item) {
        int left = 0;
        int right = numbers.length - 1;
        int partitionSize = (right - left) / 3;
        int mid1 = partitionSize + left;
        int mid2 = right - partitionSize;
        if (numbers[mid1] == item)
            return mid1;
        if (item < numbers[mid1])
            right = mid1 - 1;
        if (numbers[mid2] == item)
            return mid2;
        if (item > numbers[mid2])
            left = mid2 + 1;
        if (item > numbers[mid1] || item < numbers[mid2]) {
            left = mid1 + 1;
            right = mid2 - 1;
        }
        return -1;
    }

    public int ternarySearchrec(int[] array, int item, int left, int right) {
        if (left > right)
            return -1;
        int partitionSize = (right - left) / 3;
        int mid1 = partitionSize + left;
        int mid2 = right - partitionSize;
        if (array[mid1] == item)
            return mid1;
        if (array[mid2] == item)
            return mid2;
        if (item < array[mid1])
            return ternarySearchrec(array, item, left, mid1 - 1);
        if (item > array[mid2])
            return ternarySearchrec(array, item, mid2 + 1, right);
        return ternarySearchrec(array, item, mid1 + 1, mid2 - 1);
    }
public  int jumpsearch(int [] array,int item){
        int blocksize=(int) Math.sqrt(array.length);
        int start=0;
        int next=blocksize;
        while (array[next-1]<item) {
            start = next;
            if (start > next)
                break;
            next += blocksize;
            if (next > array.length)
                next = array.length;
        }
        for (var i=start;i<=next-1;i++)
            if (array[i]==item)
                return i;
        return -1;
}
public int exponentialSearch(int [] array,int item){
        int bound=1;
            while (bound<array.length&&array[bound]<item)
                bound *= 2;
        int upperbound= Math.min(bound,array.length-1);
        int lowerbound=bound/2;
       return binarysearch(array,item,lowerbound,upperbound);
}
}