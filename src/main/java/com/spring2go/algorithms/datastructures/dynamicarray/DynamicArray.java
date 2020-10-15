package com.spring2go.algorithms.datastructures.dynamicarray;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 动态数组实现。
 * <p>
 * 用你的实现代码替换YOUR CODE HERE
 * <p>
 * Created on Jun, 2020 by @author bobo
 */
public class DynamicArray<T> implements Iterable<T> {

    // INSTANCE VARIABLES HERE
    private T[] innerArray;
    private int length;
    private int capacity;

    public DynamicArray() {
        // YOUR CODE HERE
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity:" + capacity);
        this.capacity = capacity;
        innerArray = (T[]) new Object[capacity];
    }

    public int size() {
        // YOUR CODE HERE
        return length;
    }

    public boolean isEmpty() {
        // YOUR CODE HERE
        return size() == 0;
    }

    public T get(int index) {
        // YOUR CODE HERE
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        return innerArray[index];
    }

    public void set(int index, T elem) {
        // YOUR CODE HERE
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        innerArray[index] = elem;
    }

    public void clear() {
        // YOUR CODE HERE
        for (int i = 0; i < length; i++) {
            innerArray[i] = null;
        }
        length = 0;
    }

    public void add(T elem) {
        // YOUR CODE HERE
        if (length + 1 > capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
//            T[] newArray = (T[]) new Object[capacity];
//            for (int i = 0; i < length; i++) newArray[i] = innerArray[i];

            innerArray = Arrays.copyOf(innerArray,capacity);
        }
        innerArray[length++] = elem;
    }

    public T removeAt(int index) {
        // YOUR CODE HERE
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        T obj = innerArray[index];
        for (int i = index + 1; i < length; i++) {
            innerArray[i - 1] = innerArray[i];
        }

        innerArray[length - 1] = null;
        length--;
        return obj;
    }

    public boolean remove(T obj) {
        // YOUR CODE HERE
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(T obj) {
        // YOUR CODE HERE
        for (int i = 0; i < length; i++) {
            if (obj == null) {
                if (innerArray[i] == null) return i;
            } else {
                if (obj.equals(innerArray[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(T obj) {
        // YOUR CODE HERE
        return indexOf(obj) != -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return innerArray[index++];
            }
        };
    }

    @Override
    public String toString() {
        // YOUR CODE HERE
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) {
                sb.append(innerArray[i]).append(", ");
            }
            sb.append(innerArray[length -1]).append("]");
            return sb.toString();
        }
    }

}
