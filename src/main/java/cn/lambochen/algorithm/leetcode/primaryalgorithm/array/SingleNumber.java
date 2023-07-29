package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/14 22:53
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
 **/
public class SingleNumber {

    /**
     * 只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber handler = new SingleNumber();

        int[] nums = new int[]{2, 2, 1};
        System.out.println(handler.singleNumber(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(handler.singleNumber(nums));
    }
}
