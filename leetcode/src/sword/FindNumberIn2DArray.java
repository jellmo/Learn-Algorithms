package sword;

/**
 * <p>
 * 剑指 Offer 04. 二维数组中的查找        (难度: medium)
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </p>
 * <p>
 * 思路：
 * P47, 因为从左到右从上到下依次递增，假如在数组中随机取一个数，比target小，则target应该在这个数的右边或者下边，大则反之。
 * 所以我们可以从右上或者左下出发，来一层一层的排除行列。
 *
 * @author mohe
 * @date 2022-01-19 11:42:37
 */
public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        boolean result = false;
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            int rowLength = matrix.length;
            int columnLength = matrix[0].length;
            int row = 0;
            int column = columnLength - 1;

            while (row < rowLength && column >= 0) {
                int num = matrix[row][column];
                if (num == target) {
                    result = true;
                    break;
                }
                if (num > target) {
                    column--;
                } else {
                    row++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{}};
        findNumberIn2DArray(arr, 5);
    }
}
