package primary.string;

/**
 * <p>
 * 8. 字符串转换整数 (atoi)        (难度: medium)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * </p>
 * <p>
 * 思路：
 * 字符串转换成整数转换步骤是:
 * 从第一个数字字符开始：ans=ans*10+digit（如“987”，0*10+9=9 9*10+8=98， 98*10+7=987）
 * 而题目要求不能超过32位有符号整数范围，考虑到ans*10+digit有可能超出范围，因此移到右端判断即可。
 *
 * @author mohe
 * @date 2021-12-06 11:29:37
 */
public class Atoi {

    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        char[] str = s.toCharArray();
        //1. 先去掉空格
        while (index < n && str[index] == ' ') {
            index++;
        }
        //去掉空格之后字符串走完，则表示不是合法输入
        if (index == n) {
            return 0;
        }
        //2. 检查正负号
        int negative = 1;
        if (str[index] == '-') {
            negative = -1;
            index++;
        } else if (str[index] == '+') {
            index++;
        } else if (!Character.isDigit(str[index])) {
            //其他非数字符号
            return 0;
        }
        //3. 处理数字
        int ans = 0;
        int digit;
        while (index < n && Character.isDigit(str[index])) {
            digit = str[index] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            index++;
        }
        return ans * negative;
    }
}
