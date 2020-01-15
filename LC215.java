package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC215 {
    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     */

    // 调用库函数，O(nlogN)
    public int findKthLargestBamzhy1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //使用堆排序获取第k个最大元素
    //Java的PriorityQueue是最小堆
    public int findKthLargestBamzhy2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        while (nums.length - k > 0) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }

    //通过Comparator实现最大堆
    public int findKthLargestBamzhy3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            } else if (a < b) {
                return 1;
            } else {
                return 0;
            }
        });
        for (int num : nums) {
            queue.add(num);
        }

        while (k - 1 > 0) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    // 最快做法
    public int findKthLargestLeetCode(int[] nums, int k) {
        return quickSortInternally(nums, 0, nums.length-1, k);
    }

    private int quickSortInternally(int[] nums, int p, int r, int k) {
        int q = partation(nums, p, r);
        if (q == k-1) {
            return nums[q];
        }
        if (q > k-1) {
            return quickSortInternally(nums, p, q-1, k);
        }
        return quickSortInternally(nums, q, r, k);
    }

    private int partation(int[] nums, int p, int r) {
        int pivot = mid3(nums, p, r);
        int j = p, i = p;
        for (; i < r; ++i) {
            if (pivot <= nums[i]) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, r, j);
        return j;
    }

    private int mid3(int[] nums, int p, int r) {
        if (r - p < 2) {
            return nums[r];
        }
        int midIndex = p + ((r-p)>>1);
        if (nums[p] < nums[midIndex]) {
            swap(nums, p, midIndex);
        }
        if (nums[p] < nums[r]) {
            swap(nums, p, r);
        }
        if (nums[r] > nums[midIndex]) {
            swap(nums, midIndex, r);
        }
        swap(nums, midIndex, r);
        return nums[r];
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
