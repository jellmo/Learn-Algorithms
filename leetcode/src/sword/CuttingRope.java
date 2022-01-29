package sword;

/**
 * <p>
 * 剑指 Offer 14- I. 剪绳子
 * </p>
 * <p>
 * 思路：
 * 1. 贪心算法
 * 2. 动态规划
 * 不难得出: f(n)=MAX(f(i)*f(n-i))
 * 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积,
 * 我们先剪掉一段，剩下一段可减可不减，即取Max(j * (i - j), j * dp[i - j])
 *
 * @author mohe
 * @date 2022-01-29 10:59:09
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        /**
         * 对于1，最小单位已经没法减了，返回0
         * 对于2，只有剪一段一个减法，1*1, 返回1
         * 对于3，可以1*1*1，可以1*2，可以2*1， 返回2
         */
        if (n <= 3) {
            return n - 1;
        }
        int[] products = new int[n + 1];
        //因此对于上述3种情况，作为子段时他们不剪显然是最合适的。而对于4开始则不然
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= n; i++) {
            //Math.max(j*(i-j),j*dp[i-j])是由于减去第一段长度为j的绳子后，可以继续剪也可以不剪
            //Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]))是当j不同时，求出最大的dp[i]
            int max = 0;
            for (int j = 2; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[n];
    }
}
