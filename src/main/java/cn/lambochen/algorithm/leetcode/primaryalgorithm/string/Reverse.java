package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/18 23:51
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
 **/
public class Reverse {

    /**
     * 整数反转
     * <p>
     * 注意整数溢出
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 特殊情况处理，溢出
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        // 符号判断
        boolean flag = x < 0;
        x = flag ? -x : x;

        // 整数反转
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        // 反转结果，溢出情况处理
        if (res > Integer.MAX_VALUE) {
            return 0;
        }

        // 符号处理
        return flag ? -(int) res : (int) res;
    }

    public static void main(String[] args) {
        Reverse handler = new Reverse();
        System.out.println(handler.reverse(1534236469));
    }

}
