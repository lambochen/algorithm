package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/19 19:16
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
 **/
public class MyAtoi {

    /**
     * 字符串转换整数 atoi
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }

        boolean flag = false;
        long res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            if (str.charAt(i) == '-') {
                flag = true;
                res = handle(str, i + 1);
                break;
            }

            if (str.charAt(i) == '+') {
                res = handle(str, i + 1);
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res = handle(str, i);
            }

            break;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if (res == 0) {
            return 0;
        }

        return flag ? -(int) res : (int) res;
    }

    private long handle(String str, int index) {
        long res = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                res = res * 10 + (str.charAt(index) - '0');
            } else {
                return res;
            }

            if (res > Integer.MAX_VALUE) {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MyAtoi handler = new MyAtoi();
//        System.out.println(handler.myAtoi("42"));
//
//        System.out.println(handler.myAtoi("   -42"));
//        System.out.println(handler.myAtoi("+1"));
        System.out.println(handler.myAtoi("-2147483647"));
    }
}
