package primary.string;

/**
 * <p>
 * 125. 验证回文串      (难度: easy)
 * 验证回文串给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 思路：
 *     1. 双指针遍历
 * <p>
 * 题解：
 * 1. 字符串过滤操作使用stringbuffer，然后双指针遍历
 * 2. 字符串过滤操作使用Character.isLetterOrDigit()函数
 *
 * @author mohe
 * @date 2021-12-5 11:45:40
 */
public class Palindrome{

    /**答题**/
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        char[] str = s.toCharArray();
        int i=0, j=s.length()-1;
        boolean flag = true;
        while(i<j) {
            if (!Character.isLetterOrDigit(str[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(str[j])) {
                j--;
                continue;
            }
            if (Character.toLowerCase(str[i]) != Character.toLowerCase(str[j])) {
                flag=false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

    /**使用string buffer**/
    public boolean isPalindromeLC(String s) {
        //使用string buffer筛去所有的非字母数字字符
        StringBuffer buffer = new StringBuffer();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                buffer.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer reverse = new StringBuffer(buffer).reverse();
        return reverse.toString().equals(buffer.toString());
    }
}