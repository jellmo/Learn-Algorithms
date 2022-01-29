package sword;

/**
 * <p>
 * 剑指 Offer 15. 二进制中1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）
 * </p>
 * <p>
 * 思路：
 * 1. 循环判断每一位是否为1： 用1与n做位与运算，然后不停的将1左移，直至循环结束，这样每次都可以判断一位数。
 * （实际上这种思路右移n更简单，但是假如n为负数的话，右移补足的是符号位，与1在做位与运算会出现死循环）
 * 2. 循环消1，循环的次数是1的个数。巧用n=n&n-1消去最右边的一个1.（例：n=10100, 则n-1=10011, 于是n&n-1=10000）
 *
 * @author mohe
 * @date 2022-01-29 23:30:50
 */
public class HammingWeight {

    /**
     * 32次循环判断
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 循环消1，循环的次数是1的个数
     *
     * @param n
     * @return
     */
    public int solution(int n) {
        int count = 0;
        while (n != 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }
}
