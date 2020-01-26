package com.bamzhy.My_LeetCode.Code;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class LC49 {
    public static void main(String[] args) throws IOException {

        InputStream input = new FileInputStream("C:\\Users\\bam\\Desktop\\Code\\src\\Tools\\textFile");
        int available = input.available();
        byte[] bytes = new byte[available];
        input.read(bytes);
        String byteString = new String(bytes);
        System.out.println(byteString);
        String[] a = {""};
        System.out.println(new LC49().groupAnagramsLeetCode(a));
    }

    // 原理和我的完全相同，但是更加的简便，要仔细学习人家的写法
    public List<List<String>> groupAnagramsLeetCode(String[] strs) {
        if (strs.length == 0)
            return null;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = String.valueOf(array);
            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagramsBamzhy(String[] strs) {
        HashMap<String, ArrayList<String>> stringMap = new HashMap<>();
        if (strs == null) return null;

        // 先把所有排序后distinct的值放进map的key中
        for (String str : strs) {
            if (str != null) {
                if (str.equals("") && !stringMap.keySet().contains("")) {
                    stringMap.put(str, new ArrayList<>());
                } else {
                    char[] tempChar = str.toCharArray();
                    Arrays.sort(tempChar);
                    if (!stringMap.keySet().contains(Arrays.toString(tempChar))) {
                        stringMap.put(String.valueOf(tempChar), new ArrayList<>());
                    }
                }
            }
        }
        Set<String> mapKeyset = stringMap.keySet();
        // 然后根据map的key确定哪些值放进map的value中
        if (stringMap.size() > 0) {
            for (String str : strs) {
                if (str.equals("")) {
                    stringMap.get("").add("");
                } else {
                    char[] tempChar = str.toCharArray();
                    Arrays.sort(tempChar);
                    String s = String.valueOf(tempChar);
                    if (mapKeyset.contains(s)) {
                        stringMap.get(s).add(str);
                    }
                }
            }
        }
        return new ArrayList<>(stringMap.values());
    }
}
// 时间复杂度太可怕
//            for (String a : mapKeyset) {
//                ArrayList<String> tempList = new ArrayList<>();
//                for (String str : strs) {
//                    if (str != null) {
//                        if (str.equals("") && a.equals(str)) {
//                            tempList.add(a);
//                        } else {
//                            char[] tempChar = str.toCharArray();
//                            Arrays.sort(tempChar);
//                            if (a.equals(Arrays.toString(tempChar))) {
//                                tempList.add(str);
//                            }
//                        }
//                    }
//                }
//                resultList.add(tempList);
//            }

