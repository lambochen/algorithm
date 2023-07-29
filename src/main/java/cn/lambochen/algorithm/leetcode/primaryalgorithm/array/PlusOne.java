package cn.lambochen.algorithm.leetcode.primaryalgorithm.array;

import java.util.Arrays;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/15 22:28
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 **/
public class PlusOne {

    /**
     * 加一
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int tmp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (tmp += digits[i]) % 10;
            tmp /= 10;
        }
        if (tmp > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = tmp;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne handler = new PlusOne();

        int[] digits = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(handler.plusOne(digits)));

        System.out.println("--------------");

        digits = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(handler.plusOne(digits)));
    }

}
