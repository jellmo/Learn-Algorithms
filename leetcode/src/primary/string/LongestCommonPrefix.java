package primary.string;

/**
 * <p>
 * 14. 最长公共前缀       (难度: easy)
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * </p>
 * <p>
 * 思路：
 * 1. 横向扫描（每一次公共前缀和下一个比较）
 * 2. 纵向扫描
 *
 * @author mohe
 * @date 2021-12-09 21:51:35
 */
public class LongestCommonPrefix {

    /**
     * 纵向扫描
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //以strs[0]为公共前缀承载体
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        //循环走完说明strs[0]即为最长公共前缀
        return strs[0];
    }
}
