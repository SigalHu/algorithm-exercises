package com.sigalhu.ae.algorithm;

import com.sigalhu.ae.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序算法的稳定性：一个排序算法是稳定的，就是当有两个相等记录的关键字R和S，且在原本的列表中R出现在S之前，在排序过的列表中R也将会是在S之前。
 * 好处：一个班的学生已经按照学号大小排好序了，我现在要求按照年龄从小到大再排个序，如果年龄相同的，必须按照学号从小到大的顺序排列。
 * 那么问题来了，你选择的年龄排序方法如果是不稳定的，是不是排序完了后年龄相同的一组学生学号就乱了，你就得把这组年龄相同的学生再按照学号拍一遍。
 * 如果是稳定的排序算法，我就只需要按照年龄排一遍就好了。
 *
 * @author sigalhu
 */
public class Sort {

    /**
     * 冒泡排序
     * 对当前还未排好序的范围内的全部数，自上而下对相邻的俩个数依次进行比较和调整，让较大的数下沉，较小的数往上冒。
     * 即：每当俩相邻的数比较后发现他们的排序与排序的要求相反时，就将他们交换。每次遍历都可确定一个最大值放到待排数组的末尾，
     * 下次遍历，对该最大值以及它之后的元素不再排序（已经排好）。
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int ii = array.length - 1, exchange = 0; ii > 0; ii = exchange, exchange = 0) {
            for (int jj = 0; jj < ii; jj++) {
                if (array[jj].compareTo(array[jj + 1]) > 0) {
                    exchange = jj;
                    ArrayUtils.swap(array, jj, jj + 1);
                }
            }
        }
        return array;
    }

    /**
     * 双向冒泡排序
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] bubbleSortV2(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int ii = array.length - 1, left = 0, right = 0; ii > left; ii = right, right = left) {
            for (int jj = left; jj < ii; jj++) {
                if (array[jj].compareTo(array[jj + 1]) > 0) {
                    ArrayUtils.swap(array, jj, jj + 1);
                    right = jj;
                }
            }
            ii = left;
            for (int jj = right; jj > ii; jj--) {
                if (array[jj - 1].compareTo(array[jj]) > 0) {
                    ArrayUtils.swap(array, jj - 1, jj);
                    left = jj;
                }
            }
        }
        return array;
    }

    /**
     * 快速排序
     * （1）选择一个基准元素，通常选择第一个元素或者最后一个元素；
     * （2）通过一趟排序将待排序的记录分割成独立的两部分，其中一部分记录的元素值均比基准元素值小，另一部分记录的元素值比基准值大；
     * （3）此时基准元素在其排好序后的正确位置；
     * （4）然后分别对这两部分记录用同样的方法继续进行排序，直到整个序列有序。
     * <p>
     * 时间复杂度：
     * 平均 O(nlogn)
     * 最好 O(nlogn)
     * 最坏 O(n^2) 当数据时由小到大排列或者由大到小排列时
     * <p>
     * 空间复杂度：O(logn)
     * 稳定性：不稳定
     * <p>
     * 注意：选定第一个元素为枢纽实现起来确实很简单，但是当它为最大值或最小值时，快速排序的效率会严重降低。
     * 假如选中的元素为数组的中值，自然是最好的选择，但是却要遍历整个数组来确定中值，这个过程可能比排序花费的时间还长，得不偿失。
     * 折衷的方法是找到数组中的第一个、最后一个以及处于中间位置的元素，选出三者的中值作为枢纽，既避免了枢纽是最值的情况，
     * 也不会像在全部元素中寻找中值那样费时间。这种方法被称为“三项取中法”(median-of-three)。
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] quickSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 三项取中快速排序
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] quickSortV2(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }
        quickSortV2(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        T base = array[start];
        int left = start, right = end;
        while (true) {
            while (left < right && base.compareTo(array[right]) < 0) {
                right--;
            }
            if (left == right) {
                break;
            }
            array[left++] = array[right];

            while (left < right && base.compareTo(array[left]) > 0) {
                left++;
            }
            if (left == right) {
                break;
            }
            array[right--] = array[left];
        }
        array[left] = base;
        quickSort(array, start, left - 1);
        quickSort(array, right + 1, end);
    }

    private static <T extends Comparable<T>> void quickSortV2(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        ArrayUtils.swap(array, start + 1, (start + end) / 2);
        if (array[start].compareTo(array[start + 1]) > 0) {
            ArrayUtils.swap(array, start, start + 1);
        }
        if (array[start].compareTo(array[end]) > 0) {
            ArrayUtils.swap(array, start, end);
        }
        if (array[start + 1].compareTo(array[end]) > 0) {
            ArrayUtils.swap(array, start + 1, end);
        }

        T base = array[start + 1];
        int left = start + 1, right = end;
        while (true) {
            while (left < right && base.compareTo(array[right]) < 0) {
                right--;
            }
            if (left == right) {
                break;
            }
            array[left++] = array[right];

            while (left < right && base.compareTo(array[left]) > 0) {
                left++;
            }
            if (left == right) {
                break;
            }
            array[right--] = array[left];
        }
        array[left] = base;
        quickSortV2(array, start, left - 1);
        quickSortV2(array, right + 1, end);
    }

    /**
     * 选择排序
     * 从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推。
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int ii = 0, min = 0; ii < array.length; ii++, min = ii) {
            for (int jj = ii + 1; jj < array.length; jj++) {
                if (array[min].compareTo(array[jj]) > 0) {
                    min = jj;
                }
            }
            ArrayUtils.swap(array, ii, min);
        }
        return array;
    }

    /**
     * 二元选择排序
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] selectionSortV2(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int ii = 0, min = 0, max = array.length - 1; ii < array.length - ii; ii++, min = ii, max = array.length - 1 - ii) {
            if (array[min].compareTo(array[max]) > 0) {
                ArrayUtils.swap(array, min, max);
            }
            for (int jj = ii + 1; jj < array.length - 1 - ii; jj++) {
                if (array[min].compareTo(array[jj]) > 0) {
                    min = jj;
                }
                if (array[max].compareTo(array[jj]) < 0) {
                    max = jj;
                }
            }
            ArrayUtils.swap(array, ii, min);
            ArrayUtils.swap(array, array.length - 1 - ii, max);
        }
        return array;
    }

    /**
     * 堆排序
     * 初始时把要排序的n个数看作是一棵顺序存储的完全二叉树，调整它们的存储顺序，使之成为一个堆，将堆顶元素输出，得到n 个元素中最小（最大）的元素，
     * 这时堆的根节点的数最小（或者最大）。然后对前面(n-1)个元素重新调整使之成为堆，输出堆顶元素，得到n 个元素中次小(或次大)的元素。依次类推，
     * 直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。这个过程就称为堆排序。
     * <p>
     * 一棵完全二叉树，如果某个节点的值总是不小于其父节点的值，则根节点的关键字是所有节点关键字中最小的，称为小根堆（小顶堆）；
     * 如果某个节点的值总是不大于其父节点的值，则根节点的关键字是所有节点关键字中最大的，称为大根堆（大顶堆）。
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] heapSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        /*
         * ii = length/2-1
         * ii = ((length-1)+1)/2-1
         * 当length-1是左节点下标时，必定为奇数，+1后为右节点下标
         * 当length-1是右节点下标时，必定为偶数，+1后/2其值不变
         */
        for (int ii = array.length / 2 - 1; ii >= 0; ii--) {
            maxHeap(array, array.length, ii);
        }
        for (int ii = array.length - 1; ii > 0; ii--) {
            ArrayUtils.swap(array, 0, ii);
            maxHeap(array, ii, 0);
        }
        return array;
    }

    private static <T extends Comparable<T>> void maxHeap(T[] array, int length, int top) {
        for (int ii = 2 * top + 1; ii < length; top = ii, ii = 2 * top + 1) {
            if (ii + 1 < length && array[ii].compareTo(array[ii + 1]) < 0) {
                ii++;
            }
            if (array[top].compareTo(array[ii]) >= 0) {
                break;
            }
            ArrayUtils.swap(array, top, ii);
        }
    }

    /**
     * 插入排序
     * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * <p>
     * 时间复杂度：
     * 平均 O(n^2)
     * 最好 O(n)
     * 最坏 O(n^2)
     * <p>
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] insertionSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int ii = 1, jj; ii < array.length; ii++) {
            T tmp = array[ii];
            for (jj = ii - 1; jj >= 0 && tmp.compareTo(array[jj]) < 0; jj--) {
                array[jj + 1] = array[jj];
            }
            array[jj + 1] = tmp;
        }
        return array;
    }

    /**
     * 希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * <p>
     * 时间复杂度：
     * 平均 O(n^1.5)
     * 最好 O(n)
     * 最坏 O(n^2)
     * <p>
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] shellSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int ii = step, jj; ii < array.length; ii++) {
                T tmp = array[ii];
                for (jj = ii - step; jj >= 0 && tmp.compareTo(array[jj]) < 0; jj -= step) {
                    array[jj + step] = array[jj];
                }
                array[jj + step] = tmp;
            }
        }
        return array;
    }

    /**
     * 改进的希尔排序
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] shellSortV2(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }

        shellSortV2(array, 0);
        return array;
    }

    private static <T extends Comparable<T>> void shellSortV2(T[] array, int step) {
        step = 3 * step + 1;
        if (step > array.length) {
            return;
        }
        shellSortV2(array, step);

        for (int ii = step, jj; ii < array.length; ii++) {
            T tmp = array[ii];
            for (jj = ii - step; jj >= 0 && tmp.compareTo(array[jj]) < 0; jj -= step) {
                array[jj + step] = array[jj];
            }
            array[jj + step] = tmp;
        }
    }

    /**
     * 归并排序
     * 归并排序先将一个无序的N长数组切成N个有序子序列（只有一个数据的序列认为是有序序列），然后两两合并，
     * 再将合并后的N/2（或者N/2 + 1）个子序列继续进行两两合并，以此类推得到一个完整的有序数组。
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> T[] mergeSort(T[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return array;
        }
        merge(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void merge(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid + 1, end);

        if (array[mid].compareTo(array[mid + 1]) <= 0) {
            return;
        }
        List<T> list = new ArrayList<T>(end - start + 1);
        int ii = start, jj = mid + 1;
        while (ii <= mid && jj <= end) {
            if (array[ii].compareTo(array[jj]) <= 0) {
                list.add(array[ii++]);
            } else {
                list.add(array[jj++]);
            }
        }
        while (ii <= mid) {
            array[--jj] = array[mid--];
        }
        for (int idx = 0; idx < list.size(); idx++) {
            array[start + idx] = list.get(idx);
        }
    }

    /**
     * 基数排序
     * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * <p>
     * 时间复杂度：O(d(n+r))
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     * @return
     */
    public static Integer[] radixSort(Integer[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int r = 2, d = 32, n = array.length;

        Integer[][] buckets = new Integer[r][n];
        Integer[] count = new Integer[r];
        int radix = 1;

        while (d-- > 0) {
            Arrays.fill(count, 0);
            for (int ii = 0; ii < n; ii++) {
                int idx = (array[ii] & radix) / radix;
                buckets[idx][count[idx]++] = array[ii];
            }
            if (radix == Integer.MIN_VALUE) {
                System.arraycopy(buckets[1], 0, array, 0, count[1]);
                System.arraycopy(buckets[0], 0, array, count[1], count[0]);
            } else {
                System.arraycopy(buckets[0], 0, array, 0, count[0]);
                System.arraycopy(buckets[1], 0, array, count[0], count[1]);
            }
            radix <<= 1;
        }
        return array;
    }
}
