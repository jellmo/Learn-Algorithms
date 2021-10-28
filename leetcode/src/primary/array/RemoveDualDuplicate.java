package primary.array;

/**
 * <p>
 *     80. 删除有序数组中的重复项 II   (难度: medium)
 *     给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * </p>
 *
 * @author mohe
 * @date 2021-10-27 10:05:42
 */
public class RemoveDualDuplicate {

    public int removeDuplicates(int[] nums) {

        if (nums==null || nums.length==0) {
            return 0;
        }
        int maxRepeat=2;
        int slow=maxRepeat-1;
        for (int fast = maxRepeat; fast < nums.length; fast++) {
            if (nums[fast]!=nums[slow-maxRepeat+1]) {
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }

    public int removeDuplicates(int[] nums, int maxRepeat) {

        if (nums==null || nums.length==0) {
            return 0;
        }
        int slow=maxRepeat-1;
        for (int fast = maxRepeat; fast < nums.length; fast++) {
            if (nums[fast]!=nums[slow-maxRepeat+1]) {
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}
