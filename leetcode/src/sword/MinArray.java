package sword;

/**
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。 
 * </p>
 * <p>
 * 思路:
 * 根据旋转数组的特性，整个数组被分成了两个递增区间，且第二个递增区间开头一定是最小元素。
 * 且第二个区间一定小于等于第一个区间，所以我们可以采用二分查找的思想，第一个元素一定大于等于最后一个元素，
 * （否则说明数组旋转长度为0，直接返回首元素即可）。
 *
 * @author mohe
 * @date 2022-01-25 13:06:47
 */
public class MinArray {

    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        int pivot = 0;
        while (low < high) {
            pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
