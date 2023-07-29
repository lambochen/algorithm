package cn.lambochen.algorithm.leetcode.primaryalgorithm.string;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/9/21 23:26
 * <p>
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnpvdm/
 **/
public class CountAndSay {

    /**
     * 外观数列
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String[] resArr = new String[]{"1", "11", "21", "1211", "111221"};
        if (n <= 5) {
            return resArr[n - 1];
        }

        String res = resArr[4];
        for (int i = 6; i <= n; i++) {
            StringBuilder tmp = new StringBuilder();
            int count = 1;
            char data = res.charAt(0);
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == data) {
                    count++;
                    continue;
                }
                tmp.append(count).append(data);
                count = 1;
                data = res.charAt(j);
            }
            tmp.append(count).append(data);
            res = tmp.toString();
        }

        return res;
    }

    public static void main(String[] args) {
        CountAndSay handler = new CountAndSay();
        System.out.println(handler.countAndSay(6));
    }
}
