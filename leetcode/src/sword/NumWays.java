package sword;

/**
 * <p>
 * 剑指 Offer 10- II. 青蛙跳台阶问题。
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * </p>
 * <p>
 * 思路：
 * 在n级台阶时，青蛙可以从n-1级台阶跳上，也可以从n-2级台阶跳上，于是f(n)=f(n-1)+f(n-2)。
 *
 * @author mohe
 * @date 2022-01-25 11:31:53
 */
public class NumWays {
    private static final int MOD = 1000000007;

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int fibNMinusOne = 1;
        int fibNMinusTwo = 1;
        int fibN = 0;
        for (int i = 2; i <= n; ++i) {
            fibN = (fibNMinusOne + fibNMinusTwo) % MOD;
            fibNMinusOne = fibNMinusTwo;
            fibNMinusTwo = fibN;
        }
        return fibN;
    }
}
