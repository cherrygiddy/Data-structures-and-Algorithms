package com.company;

import java.util.ArrayList;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node first;
    private Node last;
    int size;

    public void addlast(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else
            last.next = node;
        last = node;
        size++;
    }

    public void addfirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            last = first = node;
        node.next = first;
        first = node;
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexof(int item) {
        var index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexof(item) != -1;
    }

    public void removefirst() {
        if (isEmpty())
            throw new IllegalArgumentException();
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removelast() {
        if (isEmpty())
            throw new IllegalArgumentException();
        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }
        var previous = getpreviousnode(last);
        last = previous;
        last.next = null;
        size--;
    }

    private Node getpreviousnode(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        //set the first and the last fields
        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNOdefromEnd(int k) {
        var a = first;
        var b = first;
        for (var i = 0; i < k - 1; i++) {
            b = b.next;
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalArgumentException();
        var a = first;
        var b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + "" + a.next.value);
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
    public static LinkedList createwithloop(){
        var list= new LinkedList();
        list.addlast(10);
        list.addlast(20);
        list.addlast(30);
        list.addlast(40);

        var node=list.last;//20
        list.last.next=node;

        return list;

    }
}

