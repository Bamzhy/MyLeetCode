package com.bamzhy.My_LeetCode.Code;

public class LC3 {

    /***
     * ASCⅡ字符分两种，一种是非打印控制字符，另一种是打印字符
     * 0-31 共32个非打印控制字符
     * 32-127 共96个打印字符
     * 48-57 为 0-9
     * 65-90 为 A-Z
     * 97-122为 a-z
     */

    /**
     * 我和波波做法的区别在哪里？
     * charArray[s.charAt(++r)] == 0) 与 freq[s.charAt(r + 1)] == 0)的区别
     * 我是要求每次都必须向前走一格，所以只要发现下一个char！=0，就必须把字串里l到这个值之间的所有值清空
     * 波波则是伸出去看一下，如果下一个char==0，则清空freq[l++],直到s.charAt(r+1)==0,说明已经清空干净了再往下走
     */
    public static void main(String[] args) {
        String s = "tmmzuxuz";
        System.out.println(new LC3().lengthOfLongestSubstringLiuyubo(s));
        System.out.println(new LC3().lengthOfLongestSubstringBamzhy(s));
    }

    //给定一个字符串，请你找出其中[不含有重复字符]的 最长子串 的长度。
    public int lengthOfLongestSubstringBamzhy(String s) {
        if (s.length() == 0) return 0;
        int l = 0, r = -1;
        int maxLength = 0;
        //用来查找当前字串中是否有重复元素
        int[] charArray = new int[256];
        while (r < s.length()) {
            if (r + 1 < s.length() && charArray[s.charAt(++r)] == 0) {
                charArray[s.charAt(r)]++;
                maxLength = Math.max(maxLength, r - l + 1);
                System.out.println("新增R " + s.charAt(r));
            } else if (r + 1 >= s.length()) {
                break;
            } else {
                // l直接定位到子串出现s.charAt(r)的第一个位置 L
                // 清空掉l和L之间在charArray[]中的记录
                // charArray[l+L]也需要被清除
                int L = s.substring(l, l + (r - l + 1)).indexOf(s.charAt(r));
                for (int i = l; i < l + L + 1; i++) {
                    charArray[s.charAt(i)]--;
                    System.out.println("删除L " + s.charAt(i));
                }
                l = l + L + 1;
                charArray[s.charAt(r)]++;
            }
            System.out.println("当前子串为：freq[" + l + "]...[" + r + "]");
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringLiuyubo(String s) {

        int[] freq = new int[256];

        int l = 0, r = -1;
        int res = 0;

        while (r + 1 < s.length()) {

            if (freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
                System.out.println("新增R " + s.charAt(r));
            } else {
                System.out.println("删除L " + s.charAt(l));
                freq[s.charAt(l++)]--;

            }

            res = Math.max(res, r - l + 1);

            System.out.println("当前子串为：freq[" + l + "]...[" + r + "]");
        }

        return res;
    }
}

