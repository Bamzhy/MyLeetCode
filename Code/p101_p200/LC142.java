package com.bamzhy.My_LeetCode.Code.p101_p200;

import java.io.*;
import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 */
public class LC142 {
    // 由于需要做到get/put的时间复杂度为o(1);我们需要做到查找快、插入删除快、并且有顺序
    // 使用双向链表 + HashMap
    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int size;

        public LRUCache(int size) {
            this.size = size;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            int val = map.get(key).val;
            // 利用put方法来把数据提前
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            Node x = new Node(key, val);
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (size == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);

            }
        }
    }

    class DoubleList {

        private Node head, tail;// 头尾虚节点
        private int size;//链表元素数

        // 初始化
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 在双链表头部添加节点x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        // 在双链表删除节点x x一定存在
        // 删除操作需要用到双向链表，因为删除一个节点不光光要得到该节点本身的指针
        // 还需要得到其前驱节点的指针，双向链表才能保证删除操作时O(1)的
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }


    // 因为解决不了遍历priorityQueue过程中需要修改值的问题，我的做法失败了
    class LRUCacheBamzhy {
        PriorityQueue<MyEntry<Integer, Integer>> freQueue;
        Map<Integer, Integer> valueMap;
        int maxValue;

        public LRUCacheBamzhy(int capacity) {
            if (capacity < 1)
                throw new IllegalArgumentException("LRUCache's capacity must bigger than 1 !");

            freQueue = new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            valueMap = new HashMap<>();
            maxValue = capacity;
        }

        public int get(int key) {
            if (valueMap.containsKey(key)) {
                MyEntry<Integer, Integer> temp;
                for (MyEntry<Integer, Integer> a : freQueue) {
                    if (a.getKey() == key) {
                        temp = a;
                        freQueue.offer(new MyEntry<>(key, 0));
                    } else {
                        int otherKey = a.getKey();
                        int otherValue = a.getValue();
                        freQueue.offer(new MyEntry<>(otherKey, otherValue + 1));
                    }
                }
                return valueMap.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!valueMap.containsKey(key)) {
                if (valueMap.size() < maxValue) {
                    valueMap.put(key, value);
                } else {
                    int minFreq = freQueue.poll().getKey();
                    valueMap.remove(minFreq);
                    valueMap.put(key, value);
                }

                Iterator<MyEntry<Integer, Integer>> iterator = freQueue.iterator();
                while (iterator.hasNext()) {
                    MyEntry<Integer, Integer> a = iterator.next();
                    int otherKey = a.getKey();
                    int otherValue = a.getValue();
                    freQueue.offer(new MyEntry<>(otherKey, otherValue + 1));
                }
                freQueue.offer(new MyEntry<>(key, 0));
            } else {
                valueMap.remove(key);
                valueMap.put(key, value);

                Iterator<MyEntry<Integer, Integer>> iterator = freQueue.iterator();
                while (iterator.hasNext()) {
                    MyEntry<Integer, Integer> a = iterator.next();
                    int otherKey = a.getKey();
                    int otherValue = a.getValue();
                    if (otherKey == key)
                        freQueue.offer(new MyEntry<>(otherKey, 0));
                    else
                        freQueue.offer(new MyEntry<>(otherKey, otherValue + 1));
                }
            }

        }

        class MyEntry<K, V> implements Map.Entry<K, V> {
            private final K key;
            private V value;

            MyEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public K getKey() {
                return key;
            }

            @Override
            public V getValue() {
                return value;
            }

            @Override
            public V setValue(V value) {
                this.value = value;
                return value;
            }

            @Override
            public String toString() {
                return key + "=" + value;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        LC142 l = new LC142();
        String[] a = {"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};

        List<List<Integer>> b = new ArrayList<>();
        FileReader fr = new FileReader("C:\\Users\\bam\\Desktop\\LeetCode\\src\\Personal\\test.txt");
        BufferedReader br = new BufferedReader(fr);

        String s = "";
        int i = 0;
        while ((s = br.readLine()) != null) {
            String[] split = s.split(",");
            List<Integer> temp = new ArrayList<>();
            if (split.length > 0) {
                for (String c : split) {
                    temp.add(Integer.valueOf(c));
                }
            }
            b.add(temp);
            i++;
        }

        if (i != a.length || b.size() == 0)
            throw new IllegalArgumentException("two input should have same length");

        LRUCacheBamzhy cache = new LC142().new LRUCacheBamzhy(b.get(0).get(0));
        for (int j = 1; j < i; j++) {
            if (a[j].equals("put")) {
                List<Integer> list = b.get(j);
                if (list.size() == 2) {
                    cache.put(list.get(0), list.get(1));
                    System.out.println("null");
                }

            } else {
                List<Integer> list = b.get(j);
                if (list.size() == 1)
                    System.out.println(cache.get(list.get(0)));
            }
        }

    }
}

