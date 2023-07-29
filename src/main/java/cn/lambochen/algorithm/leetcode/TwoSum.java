package cn.lambochen.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/?favorite=2cktkvj
 *
 * @author lambochen
 */
public class TwoSum {

    /**
     * 采用 Map 结构暂存已遍历数据，并逐一进行 出口值 匹配
     *
     * 时间: O(n)
     * 空间: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idxMap = new HashMap();
        for(int i=0; i<nums.length; i++) {
            Integer idx = idxMap.get(target - nums[i]);
            if(null != idx) {
                return new int[]{idx, i};
            }
            idxMap.put(nums[i], i);
        }

        return null;
    }

}
