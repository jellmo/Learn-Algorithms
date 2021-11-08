package primary.array;

import java.util.Arrays;

/**
 * <p>
 *     66. 加一           (难度: easy)
 *     给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *     你可以假设除了整数 0 之外，这个整数不会以零开头。
 * </p>
 *
 * 思路：
 *      1. 先换成数，然后加一拆分。(提交未通过，超大型数组转成long数丢失精度)
 *      2. 对于99， 999这样的数据，+1进位，需要重新建立数组，
 *          其他数据则可以在当前数组上操作，故此逆序遍历，找到第一个不为9的数据，+1即可。
 * @author mohe
 * @date 2021-11-08 16:03:49
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]!=9) {
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] nums = new int[digits.length+1];
        nums[0]=1;
        return nums;
    }
}
