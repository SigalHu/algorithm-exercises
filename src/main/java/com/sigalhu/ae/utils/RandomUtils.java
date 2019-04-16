package com.sigalhu.ae.utils;

import java.util.Random;

/**
 * @author sigalhu
 */
public class RandomUtils {

    public static Integer[] generateRandomIntegerArray(int size, int bound) {
        return new Random().ints(size, 0, bound).boxed().toArray(Integer[]::new);
    }

    public static Integer[] generateRandomIntegerArray(int size, int origin, int bound) {
        return new Random().ints(size, origin, bound).boxed().toArray(Integer[]::new);
    }
}
