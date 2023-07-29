package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 *
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class SquaresOfASortedArray {

    // 双指针法
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 1) {
            res[0] = nums[0] * nums[0];
            return res;
        }

        int left = 0, right = nums.length - 1, current = nums.length - 1;
        while (left < right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[current--] = nums[right] * nums[right];
                right--;
            } else {
                res[current--] = nums[left] * nums[left];
                left++;
            }

            if (left == right) {
                res[current] = nums[left] * nums[left];
                break;
            }
        }

        return res;
    }


}
