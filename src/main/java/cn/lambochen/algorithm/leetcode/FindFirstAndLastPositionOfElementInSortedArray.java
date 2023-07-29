package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    // 二分法
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return searchRange(nums, target, middle);
            }

            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int[] searchRange(int[] nums, int target, int index) {
        int left = index, right = index;
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray handle = new FindFirstAndLastPositionOfElementInSortedArray();

        int[] res = handle.searchRange(new int[]{2,2}, 2);
        System.out.println(res[0] + "," + res[1]);
    }

}
