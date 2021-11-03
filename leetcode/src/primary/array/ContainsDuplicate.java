package primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *     217. 存在重复元素          (难度: easy)
 *     给定一个整数数组，判断是否存在重复元素。
 *     如果存在一值在数组中出现至少两次，函数返回 true 。
 *     如果数组中每个元素都不相同，则返回 false 。
 * </p>
 *
 * 思路：
 *      1. 排序一波，然后快慢指针从前向后遍历判断有没有重复的。  （手写快排超出时限，后来
 *          用Java封装的就没问题，可能是枢轴的选择问题吧）
 *      2. 利用set集合，set集合中的元素是不能有重复的，在添加的时候，
 *          如果有重复的，会把之前的值给覆盖，并且返回false。
 *      3. hash表
 * @author mohe
 * @date 2021-10-31 19:21:52
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return !(set.size()==nums.length);
    }
}
