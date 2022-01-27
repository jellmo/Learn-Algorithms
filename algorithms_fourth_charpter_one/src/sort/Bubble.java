package sort;

/**
 * <p>
 * 冒泡排序
 * </p>
 *
 * @author mohe
 * @date 2022-01-27 12:52:51
 */
public class Bubble {

    public static int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        //一共冒泡i-1轮
        for (int i = 1; i < array.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            //一轮冒泡，已经冒泡过的末尾元素不用再继续比较
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
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
