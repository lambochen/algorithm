package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1) {
            return nums[0] > target ? 1 : 0;
        }

        int res = Integer.MAX_VALUE;
        int left = 0, right = 0, tempRes = 1, sum = nums[0];
        while (right < nums.length) {
            if (sum >= target) {
                if (tempRes < res) {
                    res = tempRes;

                    if (res == 1) {
                        return 1;
                    }
                }

                sum -= nums[left++];
                tempRes--;
            } else {
                if (right == nums.length - 1) {
                    break;
                }

                sum += nums[++right];
                tempRes++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum handler = new MinimumSizeSubarraySum();
        System.out.println(handler.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
