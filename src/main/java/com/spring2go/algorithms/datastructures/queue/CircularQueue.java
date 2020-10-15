package com.spring2go.algorithms.datastructures.queue;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;
import org.omg.CORBA.Object;

import java.util.Iterator;

public class CircularQueue<T> implements Iterable<T> {

    private T[] items;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.size = capacity;
        items = (T[]) new Object[size];
    }


    public boolean enqueue(T elem) {
        if ((tail + 1) % size == head) {
            return false;
        }

        items[tail] = elem;
        tail = (tail + 1) % size;
        return true;
    }

    public T dequeue(T elem) {
        if (head == tail) {
            return null;
        }

        T data = items[head];
        head = (head + 1) % size;

        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
