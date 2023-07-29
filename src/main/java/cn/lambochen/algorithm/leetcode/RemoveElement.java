package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * https://leetcode.cn/problems/remove-element/
 */
public class RemoveElement {

    // 暴力法
//    public int removeElement(int[] nums, int val) {
//        if (nums.length == 0) {
//            return 0;
//        }
//
//        int current = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                if (i == nums.length - 1) {
//                    nums[current] = 0;
//                    return current;
//                }
//
//                continue;
//            }
//
//            nums[current] = nums[i];
//            current++;
//        }
//
//        return current;
//    }

    // 双指针法
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
                continue;
            }

            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right--;
        }

        return left;
    }

    public static void main(String[] args) {

        RemoveElement handler = new RemoveElement();

        int[] resource = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(handler.removeElement(resource, 2));
        System.out.println();

    }

}
