package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.Arrays;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/13 16:51
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 **/
public class RemoveDuplicates {

    /**
     * 删除排序数组中的重复项
     *
     * 解题思路：双指针法。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 处理特殊情况
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res] == nums[i]) {
                // 两数相同，需要排除 i 位置，i 直接后移
                continue;
            }
            // 两数不同，则 res++， i --> res+1 位置
            nums[++res] = nums[i];
        }

        return res + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates handler = new RemoveDuplicates();

        int[] nums = new int[]{1, 1, 2};
        System.out.println(handler.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        System.out.println("--------------");

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(handler.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
