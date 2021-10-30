package primary.array;

/**
 * <p>
 * 189. 旋转数组        (难度: medium)
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * </p>
 * <p>
 * 思路：
 * 1. 暴力求解，额外建立数组遍历一波
 * 2. 贪心算法，一步一移（提交未通过，大型数组超出时限）
 * 3. 翻转数组，（题解思路）：根据K将数组分成两个部分，后K个数和
 * 前len-K个数为两部分，将后面的往前面挪，翻转一次，再恢复原来的
 * 顺序，即再翻转一次。
 *
 * @author mohe
 * @date 2021-10-29 23:36:23
 */
public class Rotate {

    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    /*1. 暴力求解
        int[] records = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            records[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=records[i];
        }
    */
    /*2. 贪心算法（提交未通过，大型数组超出时限）
        int[] records = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            records[(i+k)%nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=records[i];
        }
    */
    }
}
