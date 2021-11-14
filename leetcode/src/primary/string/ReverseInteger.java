package primary.string;

/**
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * </p>
 * <p>
 * 思路：
 * 用字符串处理反转，反转之后转换为整数，如果超出范围则捕获异常，异常处理中返回0.
 *
 * @author mohe
 * @date 2021-11-14 16:34:25
 */
public class ReverseInteger {

    public int reverse(int x) {
        String xString = Integer.toString(x);
        int flag = 1;
        if (x < 0) {
            flag = -1;
            xString = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(xString)).reverse().toString()) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
