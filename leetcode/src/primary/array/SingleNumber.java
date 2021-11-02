package primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 136. 只出现一次的数字        (难度: easy)
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * </p>
 * <p>
 * 思路：
 * 1. 暴力求解（目测超时）
 * 2. set集合，放进set如果是false，就移除，最终set里留下的就是该元素
 * 3. 不使用额外空间(位运算): 异或运算，相同为0不相同为1，故此a异或a得0，
 * 对数组中所有元素做异或处理，得到最后结果肯定为单个元素。
 *
 * @author mohe
 * @date 2021-11-02 12:32:44
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int key = 0;
        for (int num : nums) {
            key = key ^ num;
        }
        return key;
    }
}
