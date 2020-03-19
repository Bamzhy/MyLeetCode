package com.bamzhy.My_LeetCode.Algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 * 以动态数组为核心，自己搭了一个最大堆
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("this is a root node");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }

    //新加元素上浮
    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private E findMax() {
        if (data.size() == 0)
            throw new IllegalArgumentException("heap is null");
        return data.get(0);
    }

    // 新加元素下沉
    private void siftDown(int i) {
        while (leftChild(i) < data.size()) {
            int j = leftChild(i);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            // data[j]保存了leftChild和rightChild中的最大值
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private E extractMax() {
        E ret = findMax();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return ret;
    }

    // 做验证
    public static void main(String[] args) {
        int n = 1000;
        MaxHeap<Integer> maxheap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxheap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxheap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
    }
}
