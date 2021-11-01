package primary.array;

/**
 * <p>
 *     912. 排序数组        (难度: medium)
 *     给你一个整数数组 nums，请你将该数组升序排列。
 * </p>
 *
 * 思路：
 *      1. 快速排序
 * @author mohe
 * @date 2021-10-31 23:03:25
 */
public class SortArray {

    public static int[] sortArray(int[] nums) {
        if (nums==null || nums.length==0){
            return nums;
        }
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start<end) {
            int partition = partition(nums, start, end);
            quickSort(nums, start, partition-1);
            quickSort(nums, partition+1, end);
        }
    }

    public static int partition(int[] nums, int start, int end){
        int key=nums[start];
        while (start<end) {
            while (start<end && nums[end]>=key) {
                end--;
            }
            nums[start]=nums[end];
            while (start<end && nums[start]<=key) {
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start]=key;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sortArray(nums);
    }
}
