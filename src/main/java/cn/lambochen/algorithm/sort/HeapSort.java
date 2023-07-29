package cn.lambochen.algorithm.sort;

/**
 * @Description 堆排序
 * @Author chenlinghong
 * @Date 2019/3/21 16:56
 **/
public class HeapSort {

    /**
     * 将元素构造成最大堆（降序）或最小堆（升序），每次输出堆顶元素，调整堆。
     * <p>
     * 1、取出堆顶元素
     * 2、将堆底元素填充或交换至堆顶
     * 3、维护堆
     * <p>
     * 构造堆的过程（小根堆为例）：
     * 1、从最后一个非叶子节点，向前遍历。
     * 2、判断当前节点的子树根的值，是否满足小根堆，不满足，则进行替换维护。
     * 3、对于刚下推的元素，需要进一步进行确定其子树是否满足小根堆，不满足则继续下推，直至叶子节点。
     * 4、满足的情况，则继续向前遍历
     * <p>
     * 时间复杂度：
     * <p>
     * 构造堆 O(nlogn) + 取元素时维护堆 O(nlogn)
     * <p>
     * 空间复杂度：O(1)
     */

    public int[] heapSort(int[] data) {
        structureHeap(data);
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[0];
            // 堆底元素填充堆顶
            data[0] = data[data.length - 1 - i];
            maintainHeap(data, data.length - i - 1, 0);
        }
        return result;
    }


    /**
     * 维护堆
     *
     * @param data
     * @param n     堆中剩余元素个数
     * @param index 当前元素索引
     */
    private void maintainHeap(int[] data, int n, int index) {
        do {
            // index为叶子节点
            if (2 * index + 1 >= n) {
                return;
            }
            // index无右子树
            if (index * 2 + 2 >= n) {
                if (data[index] > data[index * 2 + 1]) {
                    int tmp = data[index];
                    data[index] = data[index * 2 + 1];
                    data[index * 2 + 1] = tmp;
                }
                return;
            }
            // 存在左右子树
            int tmp = index * 2 + 1;
            if (data[tmp] > data[tmp + 1]) {
                tmp++;
            }
            if (data[index] > data[tmp]) {
                int tempValue = data[index];
                data[index] = data[tmp];
                data[tmp] = tempValue;
                index = tmp;
            } else {
                return;
            }
        } while (2 * index + 2 <= n - 1);
    }


    /**
     * 构造堆
     */
    private void structureHeap(int[] data) {
        structureHeap(data, data.length);
    }

    /**
     * 构造堆结构，堆中还有n个元素
     *
     * @param data
     * @param n    堆中剩余元素个数
     */
    private void structureHeap(int[] data, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            // 只有左子树情况
            if (2 * i + 2 >= n) {
                if (data[i] > data[i * 2 + 1]) {
                    int tmp = data[i];
                    data[i] = data[i * 2 + 1];
                    data[i * 2 + 1] = tmp;
                }
            } else {
                // 左右子树均存在，堆是完全二叉树，不存在只有右子树的情况
                int tmpIndex = 2 * i + 1;
                // 取较小的一个子节点
                if (data[tmpIndex] > data[tmpIndex + 1]) {
                    tmpIndex++;
                }
                if (data[i] > data[tmpIndex]) {
                    maintainHeap(data, n, tmpIndex);
                }
            }
        }
    }
}
