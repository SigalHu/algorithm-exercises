package com.sigalhu.ae.utils;

/**
 * @author sigalhu
 */
public class ArrayUtils {

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> T[] swap(T[] array, int a, int b) {
        if (a == b) {
            return array;
        }

        T tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        return array;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
