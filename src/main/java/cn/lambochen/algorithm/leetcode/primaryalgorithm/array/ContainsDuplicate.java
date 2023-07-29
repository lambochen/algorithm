package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/13 18:01
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 **/
public class ContainsDuplicate {

    /**
     * 存在重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        return set.size() != nums.length;
    }

}
