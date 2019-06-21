package Day1;

public class LC5LongestPalindromicSubstring {
    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     *
     * time = O(n ^ 2) 注意substring()其实是O(n)的复杂度，不过可以优化，总体复杂度还是可以降到O(n^2)
     * space = O(n ^ 2);
     */

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        int max = Integer.MIN_VALUE;
        String res = "";
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                        //res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
