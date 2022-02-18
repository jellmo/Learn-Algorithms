package sword;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>
 * 剑指 Offer 40. 最小的k个数
 * </p>
 * <p>
 * 思路：
 * 1. 暴力法，排序后取前一半
 * 2. 快排思想
 * 3. 堆排序
 *
 * @author mohe
 * @date 2022-02-18 09:09:33
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0)
            return new int[0];
        if (k >= arr.length)
            return arr;
        return partition(arr, k, 0, arr.length - 1);
    }

    private int[] partition(int[] arr, int k, int left, int right) {
        int start = left, end = right;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        if (left < k)
            return partition(arr, k, left + 1, end);
        if (left > k)
            return partition(arr, k, start, right - 1);
        return Arrays.copyOf(arr, k);
    }

    /**
     * 大根堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersByHeap(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0)
            return new int[0];
        if (k >= arr.length)
            return arr;
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        int[] res = new int[queue.size()];
        int idx = 0;
        for (int num : queue) {
            res[idx++] = num;
        }
        return res;
    }
}
