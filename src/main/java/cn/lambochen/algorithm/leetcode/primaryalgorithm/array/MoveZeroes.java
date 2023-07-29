package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.Arrays;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/15 22:48
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 **/
public class MoveZeroes {

    /**
     * 移动零
     *
     * 解题思路：双指针法
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[res++] = nums[i];
            }
        }

        for (; res < nums.length; res++) {
            nums[res] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes handler = new MoveZeroes();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        handler.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
