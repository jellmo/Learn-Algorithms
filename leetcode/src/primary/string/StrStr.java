package primary.string;

/**
 * <p>
 * 28. 实现 strStr()函数          (难度: easy)
 * 给你两个字符串haystack和needle，请你在haystack字符串中找出needle字符串出现的第一个位置
 * （下标从 0 开始）。如果不存在，则返回  -1 。
 * </p>
 * <p>
 * 思路：
 * 1. KMP算法
 * 2. 暴力求解比较
 *
 * @author mohe
 * @date 2021-12-07 18:04:43
 */
public class StrStr {

    /**
     * 暴力求解比较
     **/
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char[] hayChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int i = 0, j = 0;
        while (i < hayChar.length && j < needleChar.length) {
            if (hayChar[i] == needleChar[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needleChar.length) {
            return i - needleChar.length;
        } else {
            return -1;
        }
    }
}
