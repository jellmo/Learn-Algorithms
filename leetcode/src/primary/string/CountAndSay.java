package primary.string;

/**
 * <p>
 * 38. 外观数列       (难度: medium)
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * </p>
 *
 * @author mohe
 * @date 2021-12-08 12:05:42
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        char[] str = s.toCharArray();
        StringBuffer buffer = new StringBuffer();
        int count = 1;        //计数器
        //3322251       23321511
        char local = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i] == local) {
                count++;
            } else {
                buffer.append(count);
                buffer.append(local);
                local = str[i];
                count = 1;
            }
        }
        buffer.append(count);
        buffer.append(local);
        return buffer.toString();
    }
}
