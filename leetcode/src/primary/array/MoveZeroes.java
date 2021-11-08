package primary.array;

/**
 * <p>
 *     283. 移动零         (难度: easy)
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 *      同时保持非零元素的相对顺序。
 * </p>
 *
 * 思路：
 *      遍历数组，记录第一个0的位置，继续遍历，
 *       找下一个不为0的元素，交换，位置指针进1
 * @author mohe
 * @date 2021-11-08 17:37:32
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int left=0;
        int swap=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) {
                swap=nums[i];
                nums[i]=nums[left];
                nums[left]=swap;
                left++;
            }
        }
    }
}
