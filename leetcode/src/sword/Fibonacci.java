package sword;

/**
 * <p>
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * </p>
 *
 * @author mohe
 * @date 2022-01-24 19:51:42
 */
public class Fibonacci {

    private static final int MOD = 1000000007;

    /**
     * 递归, 超时限
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2)) % MOD;
        }
    }

    /**
     * 减少重复计算，可以一项一项往后求.由之前的两数相加而得出后一项  (动态规划)
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fibNMinusOne = 0;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = (fibNMinusOne + fibNMinusTwo) % MOD;
            fibNMinusOne = fibNMinusTwo;
            fibNMinusTwo = fibN;
        }
        return fibN;
    }
}
