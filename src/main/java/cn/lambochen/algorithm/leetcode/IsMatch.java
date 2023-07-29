package cn.lambochen.algorithm.leetcode;

/**
 * @author lambochen
 * <p>
 * 正则表达式匹配
 * https://leetcode.cn/problems/regular-expression-matching/?envType=featured-list&envId=2cktkvj
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        if (s.equals(p) || ".*".equals(p)) {
            return true;
        }

        int pIdx = 0;
        for (int i = 0; i < s.length(); ) {
            if (pIdx == p.length()) {
                return false;
            }

            if (equalsDot(s.charAt(i), p.charAt(pIdx))) {
                pIdx++;
                i++;
                continue;
            } else if (pIdx > 0 && p.charAt(pIdx) == '*' && equalsDot(s.charAt(i), p.charAt(pIdx - 1))) {
                i++;
                continue;
            }

            pIdx++;
        }

        return true;
    }

    boolean equalsDot(char a, char b) {
        return a == b || b == '.';
    }

    public static void main(String[] args) {
        IsMatch match = new IsMatch();
        System.out.println(match.isMatch("ab", ".*c"));
    }

}
