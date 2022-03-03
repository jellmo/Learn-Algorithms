package sword;

/**
 * <p>
 * 剑指 Offer 42. 连续子数组的最大和
 * <p>
 * 思路：dp，与其一个一个往后加找最大，不如定住结尾的位置然后找最大子数组和
 * 我们用一个dp数组来记录当前截止的子数组的最大和，
 * 也就是说，dp[i]表示当前数组从0到第i位的连续子数组的最大和。
 * 这样有两点要注意：
 * 1. 第i位的数字绝对会参与运算
 * 2. 在这种思路之下，实际上可以判断dp[i-1]，如果它小于0，而dp[i]大于0，
 * 那么采用dp[i]即可。
 * </p>
 *
 * @author mohe
 * @date 2022-03-03 11:17:04
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            //dp[i]表示以nums[i]结尾的连续子数组的最大和
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
