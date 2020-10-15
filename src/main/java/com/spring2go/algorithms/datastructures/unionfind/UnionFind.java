package com.spring2go.algorithms.datastructures.unionfind;

/**
 * Created on Jul, 2020 by @author bobo
 */
public class UnionFind {
    // TODO YOUR INSTANCE VARIABLES HERE
    private int size;

    private int[] groupSize;

    private int[] id;

    private int numGroups;

    public UnionFind(int size) {
        // TODO YOUR CODE HERE
        if (size <= 0) throw new IllegalArgumentException("size <= 0 is not allowed");
        this.size = size;
        this.numGroups = size;

        groupSize = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
            groupSize[i] = 1;
        }
    }

    // 查找p属于哪一个组，平摊常量复杂度
    public int find(int p) {
        // TODO YOUR CODE HERE
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    // 检查p和q是否隶属于同一个组
    public boolean connected(int p, int q) {
        // TODO YOUR CODE HERE
        return find(p) == find(q);
    }

    // 返回'p'所属组的大小
    public int groupSize(int p) {
        // TODO YOUR CODE HERE
        int root = find(p);
        return groupSize[root];
    }

    // 返回并查集中的元素个数
    public int size() {
        // TODO YOUR CODE HERE
        return size;
    }

    // 返回剩余的组的数量
    public int groups() {
        // TODO YOUR CODE HERE
        return numGroups;
    }

    // 将元素'p'和'q'所在的组进行合并
    public void unify(int p, int q) {
        // TODO YOUR CODE HERE
        if (connected(p,q)) return;
        int rootp = find(p);
        int rootq = find(q);

        if (groupSize[rootp] < groupSize[rootq]) {
            groupSize[rootq] += groupSize[rootp];
            id[rootp] = id[rootq];
        } else {
            groupSize[rootp] += groupSize[rootq];
            id[rootq] = id[rootp];
        }

        numGroups--;
    }


}
