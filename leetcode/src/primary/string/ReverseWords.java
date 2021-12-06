package primary.string;

/**
 * <p>
 * 剑指 Offer 58 - I. 翻转单词顺序      (难度: easy)
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * </p>
 * <p>
 * 思路：
 * 根据空格切分字符串，然后重新组合 （分割加倒序）
 * 题解：
 * trim()函数删除首位空格，然后：
 * 双指针遍历，确定每个单词分割（不借助api的题解）
 *
 * @author mohe
 * @date 2021-12-06 12:00:29
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!"".equals(split[i])) {
                buffer.append(split[i]).append(" ");
            }
        }
        return buffer.length() == 0 ? "" : buffer.substring(0, buffer.length() - 1);
    }

    /**
     * 双指针遍历，确定每个单词分割（不借助api的题解）
     **/
    public String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        StringBuffer reverse = new StringBuffer();
        int i = s.length() - 1, j = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            reverse.append(s.substring(i + 1, j + 1)).append(" ");
            //跳过中间的空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return reverse.toString().trim();
    }
}
