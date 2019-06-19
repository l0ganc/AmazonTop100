package Day4;

public class LCCountPrimes {
    /**
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * Example:
     *
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */

    // time = O(nlogn)
    // space = O(n)
    public static int countPrimes(int n) {
        boolean[] check = new boolean[n];
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (!check[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    check[i * j] = true;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));
    }
}
