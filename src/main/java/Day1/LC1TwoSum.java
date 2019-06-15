package Day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1TwoSum {
    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    // time = O(n)
    // space = O(n)

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{i, map.get(left)};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,13};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
