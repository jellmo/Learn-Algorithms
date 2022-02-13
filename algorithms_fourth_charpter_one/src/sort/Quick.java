package sort;

/**
 * <p>
 * 快速排序
 * </p>
 *
 * @author mohe
 * @date 2022-02-13 13:35:14
 */
public class Quick {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 0)
            return new int[0];
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int partition = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= partition)
                right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= partition)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = partition;
        return left;
    }
}
