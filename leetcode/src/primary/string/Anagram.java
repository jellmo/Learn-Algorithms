package primary.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * 242. 有效的字母异位词        (难度: easy)
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * </p>
 * <p>
 * 思路：
 * 1. hash表保存t中每个字符出现的次数，然后遍历s判断是否相同
 * <p>
 * 题解：
 * 1. 长度不相等，一定不合题意，长度相等则排序后比较
 * 2. 构造一个26长度的数组，存放频数，然后遍历，若出现小于0的则说明不一致
 *
 * @author mohe
 * @date 2021-11-30 11:45:40
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        for (char c : sChar) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char d : tChar) {
            if (!map.containsKey(d)) {
                break;
            }
            Integer integer = map.get(d);
            if (integer - 1 == 0) {
                map.remove(d);
            } else {
                map.put(d, integer - 1);
            }
        }
        if (map.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 官方题解
     **/
    public boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
