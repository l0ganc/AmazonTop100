package Day4;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {
    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    // time = O(2^n)
    // space = O(n)

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        backtracking(nums, res, 0, new ArrayList<>());

        return res;
    }

    public static void backtracking(int[] nums, List<List<Integer>> res, int index, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtracking(nums, res, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
