package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/search-insert-position/
 */
public class SearchInsertPosition {

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        } else if (nums[nums.length - 1] < target) {
            return nums.length;
        } else if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return left;
    }

}
