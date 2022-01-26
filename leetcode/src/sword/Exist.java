package sword;

/**
 * <p>
 * 剑指 Offer 12. 矩阵中的路径
 * p89， 回溯法典型问题
 * </p>
 *
 * @author mohe
 * @date 2022-01-26 13:11:48
 */
public class Exist {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0 || word.length() == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, wordArray, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] word, int k, int row, int col) {
        if (k >= word.length) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || word[k] != board[row][col] || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        k++;
        boolean hasPath = backtrack(board, word, k, row + 1, col) ||
                backtrack(board, word, k, row - 1, col) ||
                backtrack(board, word, k, row, col - 1) ||
                backtrack(board, word, k, row, col + 1);
        if (!hasPath) {
            //回溯
            visited[row][col] = false;
            k--;
        }
        return hasPath;
    }
}
