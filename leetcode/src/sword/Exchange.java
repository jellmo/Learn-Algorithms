package sword;

/**
 * <p>
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * </p>
 * <p>
 * 思路： 首尾指针遍历，碰到奇数偶数就交换值
 *
 * @author mohe
 * @date 2022-02-05 16:51:06
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int i = 0, j = nums.length - 1;
        //交换变量
        int temp = -1;
        while (i < j) {
            //让i找偶数
            while (i < j && (nums[i] & 1) == 1)
                i++;
            //让j找奇数
            while (i < j && (nums[j] & 1) == 0)
                j--;
            //交换两数
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}
