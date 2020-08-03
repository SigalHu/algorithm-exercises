package com.sigalhu.ae.test.alibaba;

/**
 * @author huxujun
 * @date 2020/7/28
 */
public class Test02 {

    //评测题目: 标号1-n的n个人首尾相接，1到3报数，报到3的退出，求最后一个人的标号
    public static long func(int n) {
        long[] array = generateIncArray(n, 1);
        int size = array.length;
        int idx = -1, step = 3, zeroNum = 0, count = 0;
        while (true) {
            do {
                idx = next(array, idx);
            } while (++count % step != 0);
            if (zeroNum == size - 1) {
                return array[idx];
            }
            array[idx] = 0;
            zeroNum++;
        }
    }

    private static int next(long[] array, int current) {
        int idx = (current + 1) % array.length;
        while (array[idx] == 0) {
            idx = (idx + 1) % array.length;
        }
        return idx;
    }

    private static long[] generateIncArray(int size, long from) {
        long[] array = new long[size];
        for (int ii = 0; ii < array.length; ++ii) {
            array[ii] = from + ii;
        }
        return array;
    }

    public static void main(String[] args) {
        System.err.println(func(7));
    }
}
