package primary.array;

import java.util.Scanner;

/**
 * <p>
 *     26. 删除排序数组中的重复项      (难度: easy)
 *     给你一个有序数组 nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 *     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * </p>
 *
 * 思路：
 *      由于数组有序，故此从前向后扫描，扫描到重复的就可以删除，删除掉之后数组长度--。
 *      问题关键在于如何原地删除，采用逻辑删除。
 * @author mohe
 * @date 2021-10-25 17:48:39
 */
public class DeleteDuplicates {

    public static int removeDuplicates(int[] nums) {

        if (nums==null || nums.length==0) {
            return 0;
        }
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                continue;
            }
            nums[index+1] = nums[i];
            index++;
        }
        return index+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入几个数并用逗号隔开：");
        String str = scanner.next().toString();
        String[] arr  = str.split(",");
        int[] b = new int[arr.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(arr[i]);
        }
        int length = removeDuplicates(b);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(b[i]+" ");
        }
        scanner.close();
    }
}
