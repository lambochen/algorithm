package cn.lambochen.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
 * @author lambochen
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    // 双指针法，记录中间结果子串
    public static int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int res = 0;
        int first = 0;
        int second = first + 1;
        Map<Character, Integer> map = new HashMap();
        map.put(s.charAt(first), first);
        for(; second < s.length(); second++) {
            // 找到两个相同字符
            if(map.get(s.charAt(second)) != null) {
                if(second - first > res) {
                    res = second - first;
                }
                // 将 map 中的 first 下标更新，且 first后移，删除中间元素
                int tmp = map.get(s.charAt(second));
                for(; first<tmp+1; first++) {
                    map.remove(s.charAt(first));
                }
            }

            map.put(s.charAt(second), second);
        }

        // 执行到末尾
        if(second == s.length() && second - first > res) {
            res = second - first;
        }

        return res;
    }

}
