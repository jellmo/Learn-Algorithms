package sword;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <p>
 * 剑指 Offer 03. 数组中重复的数字        (难度: easy)
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * </p>
 * 思路：
 * 1. 排序双指针
 * 2. set集合
 * 3. 《剑指offer》P39，这个思路比较难想，而且会更改数组的值：由于数字都是小于n的，那么可以用0~n的下标
 * 去对应值，一直到发现重复的为止。也就是说，第一次遇到数字 xx 时，将其交换至索引 xx 处；
 * 而当第二次遇到数字 xx 时，一定有 nums[x] = x ，此时即可得到一组重复数字
 *
 * @author mohe
 * @date 2022-01-18 22:21:25
 */
public class FindRepeatNumber {

    /**
     * 1. 排序双指针
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int i = 0, j = 1;
        while (j <= nums.length) {
            if (nums[i] == nums[j]) {
                return nums[i];
            }
            i++;
            j++;
        }
        return -1;
    }

    /**
     * 哈希查重
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 一个萝卜一个坑
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberThree(int[] nums) {
        int swap = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = swap;
            }
        }
        return -1;
    }
}
