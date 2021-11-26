package primary.string;

import java.util.*;

/**
 * <p>
 * 387. 字符串中的第一个唯一字符        (难度: easy)
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * </p>
 * 思路：
 * 1. 先用hash表筛选一遍，有重复的就筛除掉，剩下的hash表首元素就是
 * 第一个不重复元素。   (错误， hash表存放是通过hash函数，第一个不重复元素不一定能够在表首)
 * 2. 队列，匹配先进先出     (错误，只筛选掉了成对的元素，3个元素的情况无法返回-1)
 * 解法：
 * 1. 两次遍历，第一次用hash表保存频数，第二次扫描第一个频数为1的元素，否则返回-1。
 * 2. hash表存储索引，重复元素置为-1， 然后遍历hash表，找不为-1的最小值。
 * 3. hash表存储索引，重复元素置为-1, 队列存放键值对   （这思路没咋看懂）
 *
 * @author mohe
 * @date 2021-11-26 21:36:31
 */
public class FirstUniqChar {

    /**
     * 两次遍历，第一次用hash表保存频数，第二次扫描第一个频数为1的元素，否则返回-1
     **/
    public int firstUniqCharOne(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length; i++) {
            if (map.get(str[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * hash表存储索引，重复元素置为-1， 然后遍历hash表，找不为-1的最小值。
     **/
    public int firstUniqCharTwo(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                map.put(str[i], -1);
            } else {
                map.put(str[i], i);
            }
        }
        int first = str.length;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int position = entry.getValue();
            if (position != -1 && position < first) {
                first = position;
            }
        }
        if (first == str.length) {
            first = -1;
        }
        return first;
    }
}
