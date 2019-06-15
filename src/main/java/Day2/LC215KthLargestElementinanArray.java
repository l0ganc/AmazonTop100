package Day2;

import java.util.PriorityQueue;

public class LC215KthLargestElementinanArray {
    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     */

    // method1: priorityqueue, time = O(nlogk), space = O(k)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // method2: quick select, time = O(n) and worst case is O(n^2), space = O(1)
    public static int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int position = partition(nums, left, right);
            if (position + 1 == k) {
                return nums[position];
            } else if (position + 1 < k) {
                left = position + 1;
            } else {
                right = position - 1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            } else if (nums[l] >= pivot) {
                l++;
            } else if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        System.out.println(findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
