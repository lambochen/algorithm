package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 0:11
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 **/
public class FirstUniqChar {

    /**
     * 字符串中第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        // set 用于存储之前已经确定的字符，可采用 char[] 优化
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                continue;
            }

            int j;
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    set.add(s.charAt(i));
                    break;
                }
            }

            if (j >= s.length()) {
                return i;
            }
        }
        return -1;
    }

}
