package cn.lambochen.algorithm.sort;

/**
 * @Description 简单选择排序
 * @Author chenlinghong
 * @Date 2019/3/21 15:22
 **/
public class SimpleSelectionSort {

    /**
     * 第一趟，在所有的元素中选择最小的元素放置于第一个位置
     * 第二趟，在n-1个元素中选择第二小的元素放置于第二个位置
     * 。。。
     * 倒数第二趟，选择第二大的元素放置于倒数第二个位置
     * 结束
     */

    /**
     * 第一趟，从n个记录中找出关键码最小的记录与第一个记录交换；
     *
     * 第二趟，从第二个记录开始的n-1 个记录中再选出关键码最小的记录与第二个记录交换；
     *
     * 以此类推.....
     *
     * 第i 趟，则从第i 个记录开始的n-i+1 个记录中选出关键码最小的记录与第i 个记录交换，
     *
     * 直到整个序列按关键码有序。
     */

    /**
     * 方法一：
     *
     * 在原数组中进行遍历，找到对应位置的元素，则直接进行交换位置即可。
     *
     *      优点：不需要开辟新的空间
     *
     *      缺点：破坏原数据信息
     *
     * 时间复杂度：O(n*n)
     *
     *      最好情况 O(n)：原数据基本有序的情况下，只遍历，不进行数据交换
     *
     *      最坏情况 O(n*n): 原数据与结果逆序，每一个元素都需要遍历数组直至末尾，每个数据都需要进行交换
     *
     * 空间复杂度：O(1)
     *
     */
    /**
     * 升序
     */
    public void simpleSelectionSort01(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int tmp = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[tmp]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                int t = data[tmp];
                data[tmp] = data[i];
                data[i] = t;
            }
        }
    }

    /**
     * 降序
     */
    public void simpleSelectionSort02(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int tmp = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[tmp]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                int t = data[tmp];
                data[tmp] = data[i];
                data[i] = t;
            }
        }
    }

    /**
     * 方法二：
     *
     * 1、申请新数组、标记数组。
     * 2、第一趟在原数组中选择最小的元素，填充至结果数组，并标记数据
     * 3、第二趟依次类推，直至第n趟
     *
     * 时间复杂度：O(n*n)
     *
     * 空间复杂度：O(n)
     */
    /**
     * 升序
     */
    public int[] simpleSelectionSort03(int[] data) {
        int[] result = new int[data.length];
        boolean[] flag = new boolean[data.length];
        /**
         * 初始化标记数组
         */
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        for (int i = 0; i < data.length; i++) {
            int tmp = Integer.MAX_VALUE;
            int res = 0;
            for (int j = 0; j < data.length; j++) {
                if (flag[j] && data[j] < tmp) {
                    tmp = data[j];
                    res = j;
                }
            }
            result[i] = tmp;
            flag[res] = false;
        }
        return result;
    }

    /**
     * 降序
     */
    public int[] simpleSelectionSort04(int[] data) {
        int[] result = new int[data.length];
        boolean[] flag = new boolean[data.length];
        /**
         * 初始化标记数组
         */
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        for (int i = 0; i < data.length; i++) {
            int tmp = Integer.MIN_VALUE;
            int res = 0;
            for (int j = 0; j < data.length; j++) {
                if (flag[j] && data[j] > tmp) {
                    tmp = data[j];
                    res = j;
                }
            }
            result[i] = tmp;
            flag[res] = false;
        }
        return result;
    }

    /**
     * 方法三：
     * <p>
     * 对选择排序进行优化，每一趟进行选择最大、最小两个元素
     */
    public int[] simpleSelectionSort05(int[] data) {
        int[] result = new int[data.length];
        boolean[] flag = new boolean[data.length];
        /**
         * 初始化标记数组
         */
        for (int i = 0; i < flag.length; i++) {
            flag[i] = true;
        }
        for (int i = 0; i < data.length; i++) {
            int tmpMin = Integer.MIN_VALUE;
            int tmpMax = Integer.MAX_VALUE;
            int resMin = 0;
            int resMax = 0;
            for (int j = 0; j < data.length; j++) {
                if (flag[j] && data[j] > tmpMin) {
                    tmpMin = data[j];
                    resMin = j;
                } else if (flag[j] && data[j] < tmpMax) {
                    tmpMax = data[j];
                    resMax = j;
                }
            }
            result[i] = tmpMin;
            flag[resMin] = false;
            result[data.length - 1 - i] = tmpMax;
            flag[resMax] = false;
        }
        return result;
    }

    static int[] selectionSort(int[] datas) {
        if (null == datas || datas.length <= 1) {
            return datas;
        }

        int[] res = new int[datas.length];
        boolean[] flag = new boolean[datas.length];
        for (int i = 0; i < datas.length; i++) {
            int currentMin = i;
            for (int j = i + 1; j < datas.length; j++) {
                if (!flag[j] && datas[j] < datas[currentMin]) {
                    currentMin = j;
                }
            }
            res[i] = datas[currentMin];
            flag[currentMin] = true;
        }

        return res;
    }

    static void selectionSortInOriginal(int[] datas) {
        if (null == datas || datas.length <= 1) {
            return;
        }

        for (int i = 0; i < datas.length; i++) {
            int currentMinIdx = i;
            for (int j = i + 1; j < datas.length; j++) {
                if (datas[j] < datas[currentMinIdx]) {
                    currentMinIdx = j;
                }
            }

            if (currentMinIdx != i) {
                int tmp = datas[i];
                datas[i] = datas[currentMinIdx];
                datas[currentMinIdx] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        selectionSort(new int[]{5, 2, 4, 5, 6});

        int[] datas = new int[]{5, 2, 4, 5, 6};
        selectionSortInOriginal(datas);
        System.out.println(datas);
    }
}
