package cn.lambochen.algorithm;

/**
 * @author lambochen
 *
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] datas = new int[]{1,2,3,4,5};
        System.out.println(binarySearch(datas, 3));
    }

    static int binarySearch(int[] datas, int item) {
        if (null == datas) {
            return -1;
        }

        int left = 0, right = datas.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (datas[mid] == item) {
                return mid;
            }

            if (datas[mid] > item) {
                right = mid;
            } else {
                left = mid;
            }
        }

        // 找不到对应值
        return -1;
    }
}
