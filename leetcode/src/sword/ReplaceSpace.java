package sword;

/**
 * <p>
 * 剑指 Offer 05. 替换空格        (难度: easy)
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * </p>
 * <p>
 * 思路：
 * 遍历寻找替换
 *
 * @author mohe
 * @date 2022-01-20 09:45:11
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        replaceSpace("We are happy.");
    }
}
