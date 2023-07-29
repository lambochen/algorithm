package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 18:32
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
 **/
public class IsPalindrome {

    /**
     * 验证回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
            while (head < tail) {
                if (isValidChar(s.charAt(head))) {
                    break;
                }
                head++;
            }
            while (head < tail) {
                if (isValidChar(s.charAt(tail))) {
                    break;
                }
                tail--;
            }

            if (!String.valueOf(s.charAt(head)).equalsIgnoreCase(String.valueOf(s.charAt(tail)))) {
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }

    private boolean isValidChar(char data) {
        return (data >= 'a' && data <= 'z') || (data >= 'A' && data <= 'Z') || (data >= '0' && data <= '9');
    }

    public static void main(String[] args) {
        IsPalindrome handler = new IsPalindrome();
        String data = "A man, a plan, a canal: Panama";
        System.out.println(handler.isPalindrome(data));


        data = "OP";
        System.out.println(handler.isPalindrome(data));
    }
}
