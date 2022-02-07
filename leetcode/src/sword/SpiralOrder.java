package sword;

/**
 * <p>
 * 剑指 Offer 29. 顺时针打印矩阵
 * </p>
 * <p>
 * 思路：
 * 1. 利用循环一圈一圈的打印
 * 2. 递归调用
 *
 * @author mohe
 * @date 2022-02-07 19:37:50
 */
public class SpiralOrder {

    /**
     * 循环打印
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        //定义上下边界
        int up = 0, down = matrix.length - 1;
        //定义左右边界
        int left = 0, right = matrix[0].length - 1;
        //定义索引与返回结果集
        int idx = 0;
        int[] result = new int[matrix.length * matrix[0].length];
        //开始循环打印，当上下左右边界发生交错时跳出循环（重叠时说明还有一列）
        while (true) {
            //打印上方
            for (int i = left; i <= right; i++) {
                result[idx++] = matrix[up][i];
            }
            if (++up > down)
                break;
            for (int i = up; i <= down; i++) {
                result[idx++] = matrix[i][right];
            }
            if (--right < left)
                break;
            for (int i = right; i >= left; i--) {
                result[idx++] = matrix[down][i];
            }
            if (--down < up)
                break;
            for (int i = down; i >= up; i--) {
                result[idx++] = matrix[i][left];
            }
            if (++left > right)
                break;
        }
        return result;
    }

    /**
     * 递归实现
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrderRecursion(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int row = matrix.length;
        int line = matrix[0].length;
        int[] res = new int[row * line];
        recursion(matrix, 0, row - 1, 0, line - 1, res, 0);
        return res;
    }

    //递归逻辑很简单，先顺时针打印一圈，然后递归调用
    public void recursion(int[][] matrix, int u, int d, int l, int r, int[] res, int index) {
        //递归跳出条件
        if (index >= res.length || u > d || l > r)
            return;
        for (int i = l; i <= r && index < res.length; i++)
            res[index++] = matrix[u][i];
        for (int i = u + 1; i <= d && index < res.length; i++)
            res[index++] = matrix[i][r];
        for (int i = r - 1; i >= l && index < res.length; i--)
            res[index++] = matrix[d][i];
        for (int i = d - 1; i >= u + 1 && index < res.length; i--)
            res[index++] = matrix[i][l];
        recursion(matrix, u + 1, d - 1, l + 1, r - 1, res, index);
    }
}
