package sort;

/**
 * <p>
 * 归并排序
 * </p>
 *
 * @author mohe
 * @date 2022-02-13 17:47:25
 */
public class Merge {

    int[] tmp;

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        //可以开始归并
        int count = 0;
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[count++] = nums[i++];
            } else {
                tmp[count++] = nums[j++];
            }
        }
        //一个数组已经复制完成，走另一个数组
        while (i <= mid)
            tmp[count++] = nums[i++];
        while (j <= right)
            tmp[count++] = nums[j++];
        for (int k = 0; k <= right - left; k++) {
            nums[k + left] = tmp[k];
        }
    }

}
