package Day1;

public class LC42TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * Example:
     *
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     *
     * time = O(n)
     * space = O(1)
     */

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int barL = 0, barR = 0;
        int res = 0;

        while (left < right) {
            barL = Math.max(barL, height[left]);
            barR = Math.max(barR, height[right]);
            if (barL < barR) {
                res += (barL - height[left++]);
            } else {
                res += (barR - height[right--]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
