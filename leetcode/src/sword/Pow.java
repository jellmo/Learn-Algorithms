package sword;

/**
 * <p>
 * 剑指 Offer 16. 数值的整数次方
 * </p>
 * <p>
 * 需要考虑的点：
 * 1. 指数n小于1，或者为负数怎么办
 * 2. 需不需要考虑大叔问题（越界）
 * 3. 如果x=0，n<0，对0求倒数显然是无意义的，那么如何处理异常。
 * 4. 有没有效率更快的方法。
 *
 * @author mohe
 * @date 2022-01-30 11:16:33
 */
public class Pow {

    /**
     * 循环相乘(超时限)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        boolean negative = false;
        double result = 1.0;
        long b = n;
        if (b < 0) {
            b = Math.abs(b);
            negative = true;
        }
        for (long i = 0; i < b; i++) {
            result *= x;
        }
        if (negative) {
            return 1.0 / result;
        }
        return result;
    }

    /**
     * 官方题解，递归，在原数的基础上平方，sword p112
     *
     * @param x
     * @param n
     * @return
     */
    public double solution(double x, int n) {
        boolean negative = false;
        if (n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;
            negative = true;
        }
        if (n < 0) {
            n = Math.abs(n);
            negative = true;
        }
        double result = recursion(x, n);
        if (negative) {
            return 1.0 / result;
        }
        return result;
    }

    private double recursion(double x, int n) {
        if (n == 0.0) {
            return 1.0;
        }
        if (n == 1.0) {
            return x;
        }
        //  先求x的n/2次方，用位右移代替除2操作，效率更高
        double result = recursion(x, n >> 1);
        /*如果n是奇数，result平方回来应该再乘x，偶数则不用。
         *例如n=5, 则n/2为2, 平方回来是4 */
        result *= result;
        if ((n & 1) == 1) {
            return result * x;
        } else {
            return result;
        }
    }
}
