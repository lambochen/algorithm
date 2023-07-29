package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=featured-list&envId=2cktkvj
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int resIndex = 0, resLen = 1;
        // 遍历每个字符，以 index 作为中间位置往外扩散
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1, right = i + 1;
            int lenTemp = 1;
            // 处理相同字符
            char current = s.charAt(i);
            while (left >= 0 && s.charAt(left) == current) {
                lenTemp++;
                left--;
            }
            while (right < s.length() && s.charAt(right) == current) {
                lenTemp++;
                right++;
            }

            // 左右同频扩张
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                lenTemp += 2;
                left--;
                right++;
            }

            if (lenTemp > resLen) {
                resLen = lenTemp;
                resIndex = left + 1;
            }
        }

        return s.substring(resIndex, resIndex + resLen);
    }

    public static void main(String[] args) {
        LongestPalindrome demo = new LongestPalindrome();
        System.out.println(demo.longestPalindrome("bb"));
    }

}
