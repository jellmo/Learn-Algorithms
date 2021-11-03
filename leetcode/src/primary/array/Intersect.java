package primary.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * 350. 两个数组的交集 II      (难度: easy)
 * 给定两个数组，编写一个函数来计算它们的交集。
 * </p>
 * <p>
 * 思路：
 * 1. 先排序数组，然后双指针扫描
 * 2. hash表
 *
 * @author mohe
 * @date 2021-11-03 20:33:38
 */
public class Intersect {

    /**1. 排序数组，双指针扫描
     public int[] intersect(int[] nums1, int[] nums2) {
     Arrays.sort(nums1);
     Arrays.sort(nums2);
     int[] list = new int[Math.min(nums1.length, nums2.length)];
     int i=0, j=0, k=0;
     do {
     if (nums1[i]==nums2[j]) {
     list[k]=nums1[i];
     k++;
     i++;
     j++;
     } else if (nums1[i]<nums2[j]) {
     i++;
     } else {
     j++;
     }
     } while (i<nums1.length && j<nums2.length);
     return Arrays.copyOfRange(list, 0, k);
     }
     **/

    /**
     * 2. hash表
     **/
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] list = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                list[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(list, 0, index);
    }
}
