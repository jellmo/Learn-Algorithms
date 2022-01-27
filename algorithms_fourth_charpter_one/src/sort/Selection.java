package sort;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author mohe
 * @date 2022-01-27 11:08:15
 */
public class Selection {

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        //最小元素下标
        int min = 0;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            //交换最小值与当前值
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 6, 3, 4, 7, 1, 2, 8};
        sort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
