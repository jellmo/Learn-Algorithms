package primary.array;

/**
 * <p>
 *     122. 买卖股票的最佳时机 II         (难度: medium)
 *     给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * </p>
 *
 * 思路：
 *     先找到合适买入的时间点，再找到合适卖出的时间点。通过差额确定
 *     利用贪心算法的思想(由所有局部最优解总和得到全局最优解)，简化这个问题即：
 *     计算相邻两天的差值，所有正值求和。计算的过程并不是实际的交易过程。
 * @author mohe
 * @date 2021-10-28 10:31:01
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {    //prices = [7,1,5,3,6,4]
        int total=0, profit=0;
        for (int i = 1; i < prices.length; i++) {
            profit=prices[i]-prices[i-1];
            if (profit>0) {
                total+=profit;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
}
