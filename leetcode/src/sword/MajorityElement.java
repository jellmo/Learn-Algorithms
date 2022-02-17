package sword;


/**
 * <p>
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * </p>
 *
 * @author mohe
 * @date 2022-02-17 09:34:28
 */
public class MajorityElement{

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}