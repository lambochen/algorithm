package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.Arrays;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/13 17:38
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 **/
public class RotateArray {

    /**
     * 旋转数组
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k %= nums.length;
        }

        // 1. 数组整体对折
        reverse(nums, 0, nums.length - 1);
        // 2. 前 k 个元素对折
        reverse(nums, 0, k - 1);
        // 3. 后 len-k 个元素对折
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        RotateArray handler = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        handler.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
