package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 18:14
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 **/
public class IsAnagram {

    /**
     * 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) != null ? map.get(s.charAt(i)) + 1 : 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.get(t.charAt(i)) == null) {
                return false;
            }

            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }

        for (Integer data : map.values()) {
            if (data != null && data != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsAnagram handler = new IsAnagram();

        String s = "anagram", t = "nagaram";

        System.out.println(handler.isAnagram(s, t));
    }

}
