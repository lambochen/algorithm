package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.Arrays;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/14 23:12
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 **/
public class Intersect2 {

    /**
     * 两个数组的交集 2
     *
     * 解题思路：先排序，后做比对。 最后需要 check res 数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);

        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;
        for (int i = 0, j = 0; i < nums2.length; i++) {
            if (j >= nums1.length) {
                break;
            }
            for (; j < nums1.length; j++) {
                if (nums1[j] > nums2[i]) {
                    break;
                }
                if (nums1[j] == nums2[i]) {
                    res[idx++] = nums1[j++];
                    break;
                }
            }
        }

        if (idx < res.length) {
            // 去除末尾 0 操作
            int[] resTmp = new int[idx];
            for (int i = 0; i < idx; i++) {
                resTmp[i] = res[i];
            }
            return resTmp;
        }

        return res;
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Intersect2 handler = new Intersect2();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(handler.intersect(nums1, nums2)));
        System.out.println("-----------------------");

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(handler.intersect(nums1, nums2)));
    }
}
