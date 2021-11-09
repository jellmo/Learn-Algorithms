package primary.array;

import java.util.HashMap;

/**
 * <p>
 * 1. 两数之和          (难度: easy)
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target
 * 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * </p>
 * <p>
 * 思路：
 * 1. 暴力求解, 双层遍历枚举
 * 2. 利用hash表
 *
 * @author mohe
 * @date 2021-11-09 10:31:02
 */
public class TwoSum {

    /*public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]+nums[j]==target && i!=j) {
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }*/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
