package LeetCode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
public class LC219 {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream("C:\\Users\\bam\\Desktop\\LeetCode\\src\\Tools\\textFile");
        int available = input.available();
        byte[] bytes = new byte[available];
        input.read(bytes);
        String byteString = new String(bytes);
        String[] split = byteString.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(new LC219().containsNearbyDuplicate(nums, 3500));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;//左右指针
        while (j < nums.length) {
            if (j - i <= k) {
                if (checkExist(nums, i, j, map))
                    return true;
                else
                    j++;
            } else {
                i++;
            }
        }
        return false;
    }

    private boolean checkExist(int[] nums, int i, int j, HashMap<Integer, Integer> map) {
        map.clear();
        for (int k = i; k < j + 1; k++) {
            map.put(nums[k], map.getOrDefault(nums[k], 0) + 1);
            if (map.get(nums[k]) > 1) {
                return true;
            }
        }
        return false;
    }
}
