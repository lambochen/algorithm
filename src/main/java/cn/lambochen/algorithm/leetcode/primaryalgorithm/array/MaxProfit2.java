package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/13 17:34
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 **/
public class MaxProfit2 {

    /**
     * 买卖股票的最佳时期 2
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
