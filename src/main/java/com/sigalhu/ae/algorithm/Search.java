package com.sigalhu.ae.algorithm;

import com.sigalhu.ae.utils.ArrayUtils;

/**
 * @author sigalhu
 */
public class Search {

    public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
        if (ArrayUtils.isEmpty(array) || key == null) {
            return -1;
        }

        int start = 0, end = array.length - 1, mid;
        while (true) {
            if (start == end) {
                return key.compareTo(array[start]) == 0 ? start : -1;
            }
            mid = (start + end) >>> 1;
            if (key.compareTo(array[mid]) > 0) {
                start = mid + 1;
            } else if (key.compareTo(array[mid]) < 0) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
    }
}
