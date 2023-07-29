package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/17 23:25
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 **/
public class TwoSum {

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
