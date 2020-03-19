package com.bamzhy.My_LeetCode.Algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(Comparable[] array) {
        int n = array.length;
        Comparable[] temp = new Comparable[n];
        System.arraycopy(array, 0, temp, 0, n);

        /**
         * elementSize表示每次执行排序元素的个数
         * elementSize增长趋势 1——>2——>4...
         * 首层循环表示了对全部n个元素，执行‘倍增的elementSize数据排序’
         * 第一次，在第二层循环中对n个元素每两个执行一次排序
         * 第二次，在第二层循环中对n个元素每四个执行一次排序
         * ...
         * 第二层循环执行了排序
         */
        for (int elementSize = 1; elementSize < n; elementSize += elementSize) {
            // i+=(2*elementSize) 所谓 ‘归并’
            for (int i = 0; i < n; i += (2 * elementSize)) {
                // 参数分别为 结果数组，第一个数组起始序号，第一个数组结束序号，第二个数组结束序号，temp数组
                // 需要比较i+2*elementSize-1 与 n-1 大小的区别 防止越界
                merge(array, i, i + elementSize - 1, Math.min(i + 2 * elementSize - 1, n - 1), temp);
            }
        }
        System.out.println("处理后为："+Arrays.toString(array));
    }

    private static void merge(Comparable[] array, int l, int mid, int r, Comparable[] temp) {
        for (int i = l; i <= r; i++) {
            temp[i] = array[i];
        }
        // array[l(i)...mid], array[mid+1(j)...r]
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 判断索引的合法性
            if (i > mid) {
                array[k] = temp[j];
                j++;
            } else if (j > r) {
                array[k] = temp[i];
                i++;
            }
            // 执行数据排序
            else if (temp[i].compareTo(temp[j]) < 0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {1,100,12,45,7,22,4, 5, 3, 4, 5, 6, 2, 34, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(a);
    }
}
