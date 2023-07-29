package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/20 11:10
 *
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
 **/
public class StrStr {

    /**
     * 实现 strStr
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle == null || "".equalsIgnoreCase(needle) || haystack.equals(needle)) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(j + i) != needle.charAt(j)) {
                        break;
                    }
                }

                if (j >= needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }

}
