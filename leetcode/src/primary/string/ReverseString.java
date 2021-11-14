package primary.string;

/**
 * <p>
 * 344. 反转字符串           (难度: easy)
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * </p>
 * <p>
 * 思路：
 * 1. 直接翻转
 * 2. 递归
 *
 * @author mohe
 * @date 2021-11-14 16:21:08
 */
public class ReverseString {

    public void reverseString(char[] s) {
        char key;
        int left = 0, right = s.length - 1;
        while (left < right) {
            key = s[left];
            s[left] = s[right];
            s[right] = key;
            left++;
            right--;
        }
    }
}
