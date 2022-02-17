package sword;


import java.util.Arrays;

/**
 * <p>
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * </p>
 * <p>
 * 思路：  （下记目标数字为target）
 * 1. 排序后遍历，则target一定出现在中间位置。
 * 2. 抵消思路：由于target的个数超过数组的一半，因此用一个target抵消一个其他元素，数组中最后只剩target。
 * 基于这种思路，我们可以使用element记录当前元素，count计数，一样则count加一，不一样则count-1，
 * 当count为0时，则换element为下一个元素，这样到最后element即为target。
 *
 * @author mohe
 * @date 2022-02-17 09:34:28
 */
public class MajorityElement {

    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
                continue;
            }
            if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }
}