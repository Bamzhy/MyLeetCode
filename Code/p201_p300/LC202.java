package com.bamzhy.My_LeetCode.Code.p201_p300;

import java.util.HashSet;
import java.util.Stack;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

/* the most important thing
   make sure which situation to stop
   1 temp < 10 and temp !=1
   2 a set which stores temp number contains duplicate values
 */
/*
   快慢指针 fast pointer and slow pointer
   找中间值
       一般的思路是：先遍历一次链表，记录住一共有多少个节点，然后，再次遍历找寻中点。
       利用快慢指针，我们来看看这个问题会变成什么样。
       思路如下：我们把一个链表看成一个跑道，假设a的速度是b的两倍，那么当a跑完全程后，b刚好跑一半，以此来达到找到中间节点的目的。
   判断链表中的环
       快慢指针中，因为每一次移动后，快指针都会比慢指针多走一个节点，
       所以他们之间在进入环状链表后，不论相隔多少个节点，慢指针总会被快指针赶上并且重合，此时就可以判断必定有环。
   删除倒数第n个节点
       删除倒数第n个节点，那就等于是要我们先找出待删除元素前一个元素，也就是第n-1个节点。
       我们又把这个问题转化为找链表上的某个节点的问题了，这是快慢指针最擅长的场景。
       那如何找第(n-1)个元素呢？我们一开始就让fast指针比slow指针快n+1个元素，
       接下来，两个指针都是一步一步来往下走。那么当fast指针走完时，slow指针就刚刚好停留在第(n-1)个元素上。
 */
public class LC202 {
    public boolean isHappyBobo(int n) {
        HashSet<Integer> record = new HashSet<>();
        record.add(n);
        while (n != 1) {
            n = op(n);
            if (record.contains(n)) {
                return false;
            } else {
                record.add(n);
            }
        }
        return true;
    }

    public int op(int n) {
        int res = 0;
        while (n > 0) {
            int t = n % 10;
            n = n / 10;
            res += t * t;
        }
        return res;
    }

    public boolean isHappyBamzhy(int n) {
        int temp = transferNumber(n);
        while (temp != 1) {
            temp = transferNumber(temp);
            if (temp < 10 && temp != 1) {
                return false;
            }
        }
        return true;
    }

    private int transferNumber(int n) {
        Stack<Integer> tempList = new Stack<>();
        while (n > 0) {
            tempList.add(n % 10);
            n = n / 10;
        }
        int result = 0;
        while (!tempList.empty()) {
            Integer pop = tempList.pop();
            result += pop * pop;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LC202().isHappyBamzhy(19));
    }
}
