package com.spring2go.algorithms.datastructures.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 基于双向链表的队列实现
 *
 * 用你的实现代码替换YOUR CODE HERE.
 *
 * Created on Jun, 2020 by @author bobo
 */
public class LinkedQueue<T> implements Iterable<T> {

    // INSTANCE VARIABLES HERE
    private LinkedList<T> list = new LinkedList<>();

    // 创建一个空队列
    public LinkedQueue() {}

    // 创建一个带有一个初始元素的队列
    public LinkedQueue(T firstElem) {
        // YOUR CODE HERE
        offer(firstElem);
    }

    // 返回队列的大小
    public int size() {
        // YOUR CODE HERE
        return list.size();
    }

    // 检查队列是否为空
    public boolean isEmpty() {
        // YOUR CODE HERE
        return list.isEmpty();
    }

    // 查看一下队头的元素，如果队列为空则抛出一个异常
    public T peek() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return list.peekFirst();
    }

    // 从队列中取出一个元素，如果队列为空则抛出一个异常
    public T poll() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Queue is Empty");
        return list.removeFirst();
    }

    // 添加一个元素到队尾
    public void offer(T elem) {
        // YOUR CODE HERE
        list.addLast(elem);
    }

    // 返回一个迭代器，可以对队列中元素进行迭代遍历
    @Override
    public Iterator<T> iterator() {
        // YOUR CODE HERE
        return list.iterator();
    }
}
