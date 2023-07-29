package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/21 23:38
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
 **/
public class LongestCommonPrefix {

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder common = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j] == null) {
                    return "";
                }
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return common.toString();
                }
            }
            common.append(strs[0].charAt(i));
        }
        return common.toString();
    }

}
