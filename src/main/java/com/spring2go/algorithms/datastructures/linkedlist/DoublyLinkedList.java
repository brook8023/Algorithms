package com.spring2go.algorithms.datastructures.linkedlist;

import java.util.Iterator;

/**
 * 双向链表实现.
 * <p>
 * 用你的实现代码替换YOUR CODE HERE.
 * <p>
 * Created on Jun, 2020 by @author bobo
 */
public class DoublyLinkedList<T> implements Iterable<T> {

    // INSTANCE VARIABLES HERE
    private int size;
    private Node<T> head;
    private Node<T> tail;

    // 内部节点类
    private static class Node<T> {
        private T data; // 数据
        private Node<T> prev, next; // 前向和后向指针

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    // 将链表清空，O(n)
    public void clear() {
        // YOUR CODE HERE
        Node<T> trav = head;
        while (trav != null) {
            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            trav = next;
        }

        head = tail = null;
        size = 0;
    }

    // 返回链表的长度
    public int size() {
        // YOUR CODE HERE
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        // YOUR CODE HERE
        return size() == 0;
    }

    // 向链表的尾部添加一个元素, O(1)
    public void add(T elem) {
        // YOUR CODE HERE
        addLast(elem);
    }

    // 向链表的尾部添加一个元素, O(1)
    public void addLast(T elem) {
        // YOUR CODE HERE
        if (isEmpty()) {
            head = tail = new Node<>(elem ,null,null);
        } else {
            tail.next = new Node<>(elem,tail,null);
            tail = tail.next;
        }
        size++;
    }

    // 在链表的头部添加一个元素，O(1)
    public void addFirst(T elem) {
        // YOUR CODE HERE
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    // 向指定的索引位置添加一个元素
    public void addAt(int index, T data) {
        // YOUR CODE HERE
        if (index < 0 || index > size) throw new RuntimeException("Illegal Index");
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        Node<T> newNode = new Node<>(data,tmp,tmp.next);
        tmp.next.prev = newNode;
        tmp.next = newNode;

        size++;
    }

    // 获取第一个节点的值，如果存在的话, O(1)
    public T peekFirst() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Empty list");
        return head.data;
    }

    // 获取最后一个节点的值，如果存在的话，O(1)
    public T peekLast() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Empty list");
        return tail.data;
    }

    // 移除链表中的头部节点，并返回它的值，O(1)
    public T removeFirst() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = head.data;
        head = head.next;
        size--;

        if (isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    // 移除链表中的最后一个节点，并返回它的值，O(1)
    public T removeLast() {
        // YOUR CODE HERE
        if (isEmpty()) throw new RuntimeException("Empty list");
        T data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    // 移除链表中的一个指定的节点，O(1)
    // 内部使用
    private T remove(Node<T> node) {
        // YOUR CODE HERE
        if (node.prev == null) return removeFirst();
        if (node.next == null) return removeLast();

        node.prev.next = node.next;
        node.next.prev = node.prev;

        T data = node.data;
        node = node.prev = node.next = null;
        size--;
        return data;
    }

    // 移除指定索引位置的节点，O(n)
    public T removeAt(int index) {
        // YOUR CODE HERE
        if (index < 0 || index > size) throw new RuntimeException("Illegal Index");

        int i;
        Node<T> trav;
        if (index < size / 2) {
            for (i = 0, trav = head; i < index; i++) {
                trav = trav.next;
            }
        } else {
            for (i = size - 1, trav = tail; i > index; i--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    // 在链表中移除指定的对象, O(n)
    public boolean remove(Object obj) {
        // YOUR CODE HERE
        Node<T> trav = head;
        if (obj == null) {
            for (; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (; trav != null; trav = trav.next) {
                if (obj.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }

        return false;
    }

    // 查找指定对象在链表中的索引, O(n)
    public int indexOf(Object obj) {
        // YOUR CODE HERE
        int index = 0;
        Node<T> trav = head;
        if (obj == null) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
        } else {
            for (; trav != null; trav = trav.next, index++) {
                if (obj.equals(trav.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    // 检查链表中是否包含某个值
    public boolean contains(Object obj) {
        // YOUR CODE HERE
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        // YOUR CODE HERE
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return head != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }


    @Override
    public String toString() {
        // YOUR CODE HERE
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
