package dynamic;

/**
 * <p>
 * 53. 最大子数组和       (难度: easy)
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * </p>
 * <p>
 * 思路：
 * 1. 贪心算法，先求前面的和，如果是负数丢掉重新开始求和
 * 2. 动态规划，既然求最大和连续子数组的和，那么一步一步求，是正数则说明可以加到后面，是负数就丢掉重来
 * 私以为这两个思路很像
 *
 * @author mohe
 * @date 2022-01-14 19:45:11
 */
public class MaxSubArray {

    //nums = [-2,1,-3,4,-1,2,1,-5,4]

    public int maxSubArray(int[] nums) {
        if (nums != null || nums.length == 0) {
            return -1;
        }
        int curSum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (curSum > 0) {
                //正数则加到后面
                curSum = curSum + nums[i];
            } else {
                //负数则重来
                curSum = nums[i];
            }
            if (maxSum < curSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }
}
