package sword;

/**
 * <p>
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * </p>
 * <p>
 * 思路：
 * 经典大数问题，这个题目的难点是要想到数据溢出，因此打印要么用字符串要么用数组。
 *
 * @author mohe
 * @date 2022-01-30 15:12:12
 */
public class PrintNumbers {

    public int[] printNumber(int n) {
        if (n <= 0) {
            return new int[0];
        }
        int length = 0;
        for (int i = 0; i < n; i++) {
            length = length * 10 + 9;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    //用字符串模拟数字加法
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        // 数字字符串集
        res = new StringBuilder();
        // 定义长度为 n 的字符列表
        num = new char[n];
        // 开启全排列递归
        dfs(0);
        // 删除最后多余的逗号
        res.deleteCharAt(res.length() - 1);
        return res.toString(); // 转化为字符串并返回
    }

    void dfs(int x) {
        if (x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for (char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }
}
