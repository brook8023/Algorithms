package com.spring2go.algorithms.datastructures.binarysearchtree;

import java.util.*;

/**
 * 二叉搜索树(BST)实现。
 * <p>
 * Created on Jul, 2020 by @author bobo
 */
public class BinarySearchTree<T extends Comparable<T>> {
    // TODO YOUR INSTANCE VARIABLES HERE
    private int nodeCount;

    private Node root;

    // 内部节点定义，包含数据和引用
    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    // 检查二叉搜索树是否为空
    public boolean isEmpty() {
        // TODO YOUR CODE HERE
        return size() == 0;
    }

    // 获取二叉搜索树中节点的数量
    public int size() {
        // TODO YOUR CODE HERE
        return nodeCount;
    }

    // 向二叉搜索树中添加一个元素，如果成功执行添加就返回true
    public boolean add(T elem) {
        // TODO YOUR CODE HERE
        if (contains(elem)) {
            return false;
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    // 私有方法，在二叉搜索树中递归添加一个元素
    private Node add(Node node, T elem) {
        // TODO YOUR CODE HERE
        if (node == null) {
            node = new Node(null, null, elem);
        } else {
            int cmp = elem.compareTo(node.data);

            if (cmp < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }

        return node;
    }

    // 从二叉搜索树中移除一个元素，如果存在的话，复杂度：O(n)
    public boolean remove(T elem) {
        // TODO YOUR CODE HERE
        if (contains(elem)) {
            root = remove(root,elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        // TODO YOUR CODE HERE
        if (node == null) {
            return null;
        }

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node rightChild = node.right;

                node.data = null;
                node = null;
                return rightChild;
            } else if (node.right == null) {
                Node leftChild = node.left;

                node.data = null;
                node = null;
                return leftChild;
            } else {
                Node tmp = findMin(node.right);
                node.data = tmp.data;

                node.right = remove(node.right,tmp.data);
            }
        }

        return node;
    }

    // 助手方法，查找最左节点(值最小)
    private Node findMin(Node node) {
        // TODO YOUR CODE HERE
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 助手方法，查找最右节点(值最大)
    private Node findMax(Node node) {
        // TODO YOUR CODE HERE
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // 如果元素存在于树中，就返回true，否则返回false
    public boolean contains(T elem) {
        // TODO YOUR CODE HERE
        return contains(root, elem);
    }

    // 私有递归方法，在树中寻找一个元素
    private boolean contains(Node node, T elem) {
        // TODO YOUR CODE HERE
        if (node == null) {
            return false;
        }

        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            return contains(node.left, elem);
        } else if (cmp > 0) {
            return contains(node.right, elem);
        }

        return true;
    }

    // 计算树的高度，O(n)
    public int height() {
        // TODO YOUR CODE HERE
        return height(root);
    }

    // 计算树的高度的递归助手方法
    private int height(Node node) {
        // TODO YOUR CODE HERE
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left),height(node.right)) + 1;
    }

    // 返回特定遍历顺序的的迭代器，
    // 支持先序(preorder)，中序(inorder)，后序(postorder)和按层次遍历(levelorder)
    public java.util.Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            case LEVEL_ORDER:
                return levelOrderTraversal();
            default:
                return null;
        }
    }


    // 返回先序遍历一棵树的迭代器
    private java.util.Iterator<T> preOrderTraversal() {
        // TODO YOUR CODE HERE
        final int exceptedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);

                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 返回中序遍历一棵树的迭代器
    private java.util.Iterator<T> inOrderTraversal() {
        // TODO YOUR CODE HERE
        final int exceptedNodeCount = nodeCount;
        final Stack<Node> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {

            Node trav = root;

            @Override
            public boolean hasNext() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();

                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node node = stack.pop();

                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }
                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 返回后序遍历一棵树的迭代器
    private java.util.Iterator<T> postOrderTraversal() {
        // TODO YOUR CODE HERE
        final int exceptedNodeCount = nodeCount;
        final Stack<Node> stack1 = new Stack<>();
        final Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return stack2.pop().data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 返回按层次遍历一棵树的迭代器
    private java.util.Iterator<T> levelOrderTraversal() {
        // TODO YOUR CODE HERE
        final int exceptedNodeCount = nodeCount;
        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !queue.isEmpty();            }

            @Override
            public T next() {
                if (exceptedNodeCount != nodeCount) throw new ConcurrentModificationException();
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                return node.data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

