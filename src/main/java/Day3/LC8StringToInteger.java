package Day3;

public class LC8StringToInteger {
    /**
     * 8. String to Integer (atoi)
     * Example 1:
     *
     * Input: "42"
     * Output: 42
     * Example 2:
     *
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     *              Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     *
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     *
     */

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        char firstChar = str.charAt(0);

        int sign = 1, start = 0, n = str.length();
        long sum = 0;

        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < n; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && ((-1) * sum) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)sum * sign;
    }
}
