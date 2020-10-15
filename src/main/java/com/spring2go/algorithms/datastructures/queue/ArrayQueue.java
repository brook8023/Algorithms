package com.spring2go.algorithms.datastructures.queue;

import org.omg.CORBA.Object;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T> {

    private T[] items;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.size = capacity;
        items = (T[]) new Object[size];
    }


    public boolean enqueue(T elem) {
        if (tail == size) {
            if (head == 0) {
                return false;
            }

            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail++] = elem;
        return true;
    }

    public T dequeue(T elem) {
        if (head == tail) {
            return null;
        }

        T data = items[head];
        head++;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
