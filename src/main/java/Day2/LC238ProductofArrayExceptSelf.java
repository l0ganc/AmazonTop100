package Day2;

import java.util.Arrays;

public class LC238ProductofArrayExceptSelf {
    /**
     * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     *
     *
     */


    // 使用额外空间
    // time = O(n)
    // space = O(n)
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        left[0] = right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }


    // 优化空间到O(1), 其实还是一样的方法，就是用一个变量存下从后往前除了当前元素的以外其他元素的乘积
    public static int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        int[] res = new int[n];

        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        // Calculate rights and store in res.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }
}
