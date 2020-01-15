package LeetCode;

import java.util.*;

public class LC15 {

    public static void main(String[] args) {
        int[] a = { 0,  0, 0};
        List<List<Integer>> lists = new LC15().threeSum(a);
        System.out.println(lists.toString());
    }

    /**
     * 给定一个包含 n 个整数的数组 nums，
     * 判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     */

    // 将数组排序[0,length-1]，然后遍历数组，每次从i的两边各获取一个值，问题退化成为n个twoSum问题
    public List<List<Integer>> threeSumbamzhy(int[] nums) {
        HashSet<List<Integer>> listSet = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if (nums.length < 3) return new ArrayList<>(listSet);
        // 记录各个值出现次数
        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            // 获取全部可能解并用set去重
            ArrayList<ArrayList<Integer>> lists = twoSum(nums, target);
            for (ArrayList<Integer> a : lists) {
                if (a.size() == 2) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(a.get(0));
                    tempList.add(a.get(1));
                    Collections.sort(tempList);
                    // 这三个if是为了防止出现 结果中相同元素的数量大于 nums[]数组中相同元素的数量
                    if (tempList.get(0).equals(tempList.get(1))) {
                        if (map.get(tempList.get(0)) < 2) {
                            continue;
                        }
                    }
                    if (tempList.get(1).equals(tempList.get(2))) {
                        if (map.get(tempList.get(1)) < 2) {
                            continue;
                        }
                    }
                    if (tempList.get(0).equals(tempList.get(1))
                            && tempList.get(1).equals(tempList.get(2))) {
                        if (map.get(tempList.get(0)) < 3) {
                            continue;
                        }
                    }
                    listSet.add(tempList);
                }
            }

        }
        return new ArrayList<>(listSet);
    }

    // 找出所有两数之和大于 target 的组合，并且不去重
    public ArrayList<ArrayList<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int l = 0, r = nums.length - 1;
        while (l < r) {

            if (nums[l] + nums[r] == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                l++;
                r--;
                arrayLists.add(temp);
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return arrayLists;
    }

    public int[] twoSumIndex(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        Arrays.sort(nums);
        int[] resultArray = new int[2];
        int l = 0, r = nums.length - 1;
        while (l < r) {

            if (nums[l] + nums[r] == target) {
                for (int i : map.keySet()) {
                    if (map.get(i) == nums[l]) {
                        resultArray[0] = i;
                        break;
                    }
                }
                for (int j : map.keySet()) {
                    if (map.get(j) == nums[r]) {
                        if (nums[l] == nums[r]) {
                            if (j > resultArray[0]) {
                                resultArray[1] = j;
                                break;
                            }
                        } else {
                            resultArray[1] = j;
                            break;
                        }
                    }
                }
                Arrays.sort(resultArray);
                return resultArray;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return resultArray;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三个数字之和一定大于0
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0)
                    R--;
            }
        }
        return result;
    }
}
