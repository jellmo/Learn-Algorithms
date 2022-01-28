package sword;

/**
 * <p>
 * 剑指 Offer 13. 机器人的运动范围
 * P92, 回溯算法经典问题
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * </p>
 *
 * @author mohe
 * @date 2022-01-27 13:53:23
 */
public class MovingCount {

    public int movingCount(int m, int n, int k) {
        //参数校验
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        //访问标记数组
        boolean[][] visited = new boolean[m][n];
        return backtrack(m, n, 0, 0, k, visited);
    }

    public int backtrack(int m, int n, int i, int j, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        //已访问过，不计数。
        if (visited[i][j]) {
            return 0;
        }
        //数位之和大于K，不计数
        if (getSum(i) + getSum(j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + backtrack(m, n, i - 1, j, k, visited)
                + backtrack(m, n, i + 1, j, k, visited)
                + backtrack(m, n, i, j - 1, k, visited)
                + backtrack(m, n, i, j + 1, k, visited);
    }

    public static int getSum(int sum) {
        int count = 0;
        while (sum > 0) {
            count += sum % 10;
            sum /= 10;
        }
        return count;
    }
}
