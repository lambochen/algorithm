package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/18 23:46
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 **/
public class ReverseString {

    /**
     * 反转字符串
     *
     * @param s
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
