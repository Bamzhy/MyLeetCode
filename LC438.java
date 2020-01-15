package LeetCode;

import java.util.*;

public class LC438 {
    // 时间复杂度不行 1379 ms
    public List<Integer> findAnagrams1(String s, String p) {
        if (s.length() == 0) return new ArrayList<>();
        // 字串长度
        int l = 0;
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        ArrayList<Integer> resultList = new ArrayList<>();
        while (l < (sArray.length - pArray.length + 1)) {
            checkEquals1(resultList, l, sArray, pArray);
            l++;
        }
        return resultList;
    }

    private void checkEquals1(ArrayList<Integer> resultList, int l, char[] sArray, char[] pArray) {
        char[] a = new char[pArray.length];
        for (int i = 0; i < pArray.length; i++) {
            a[i] = sArray[l + i];
        }
        Arrays.sort(a);
        if (Arrays.equals(a, pArray)) {
            resultList.add(l);
        }
    }

    public static void main(String[] args) {
        String a = "cbaebabacd";
        String b = "abc";
        System.out.println(new LC438().findAnagramsLeetCode(a, b));
    }

    // 提升到8ms 太牛逼了
    public List<Integer> findAnagramsLeetCode(String s, String p) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        int[] needs = new int[26];
        int[] window = new int[26];

        int left = 0, right = 0;
        //用total检测窗口中是否已经涵盖了p中的字符
        int total = p.length();

        //needs存放所有p中的字符出现的次数
        for (char ch : p.toCharArray()) {
            needs[ch - 'a']++;
        }

        // 返回的结果
        List<Integer> res = new ArrayList<>();

        // 滑动窗口的典型特征
        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs[chr - 'a'] > 0) {
                window[chr - 'a']++;
                if (window[chr - 'a'] <= needs[chr - 'a']) {
                    total--;
                }
            }
            // total==0时，表示needs[]中的字符都遍历到了，如果r-l+1=p.length()好你就是最终答案之一
            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                //从window的left一端开始，逐渐开始释放total
                char chl = s.charAt(left);
                if (needs[chl - 'a'] > 0) {
                    window[chl - 'a']--;
                    if (window[chl - 'a'] < needs[chl - 'a']) {
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
