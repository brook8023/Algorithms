package com.spring2go.algorithms.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 基于链表实现的栈.
 *
 * 用你的实现代码替换YOUR CODE HERE.
 *
 * Created on Jun, 2020 by @author bobo
 */
public class ListStack<T> implements Iterable<T> {

    // INSTANCE VARIABLES HERE
    private LinkedList<T> list = new LinkedList<>();

    // 创建一个空栈
    public ListStack() {}

    // 创建一个带有一个初始元素的栈
    public ListStack(T firstElem) {
        // YOUR CODE HERE
        push(firstElem);
    }

    // 返回栈中的元素个数
    public int size() {
        // YOUR CODE HERE
        return list.size();
    }

    // 检查栈是否为空
    public boolean isEmpty() {
        // YOUR CODE HERE
        return list.isEmpty();
    }

    // 从栈中弹出一个元素
    // 如果栈空就抛出一个异常
    public T pop() {
        // YOUR CODE HERE
        if(list.isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    // 查看栈顶元素(并不移除)
    // 如果栈空就抛出一个异常
    public T peek() {
        // YOUR CODE HERE
        if(list.isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    // 将一个元素入栈
    public void push(T elem) {
        // YOUR CODE HERE
        list.addLast(elem);
    }

    // 支持以迭代器方式对栈进行遍历
    @Override
    public Iterator<T> iterator() {
        // YOUR CODE HERE
        return list.iterator();
    }
}
