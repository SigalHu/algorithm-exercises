package com.sigalhu.ae.utils;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sigalhu
 * @date 2019/4/16
 */
public class RandomUtilsTest {

    private int size = 1000;
    private int origin = -100;
    private int bound = 100;

    @Test
    public void generateRandomIntegerArray() {
        Integer[] array = RandomUtils.generateRandomIntegerArray(size, bound);
        Assert.assertNotNull(array);
        Assert.assertEquals(size, array.length);
        Assert.assertThat(Arrays.asList(array), Matchers.everyItem(Matchers.allOf(Matchers.greaterThanOrEqualTo(0), Matchers.lessThan(bound))));
    }

    @Test
    public void generateRandomIntegerArray1() {
        Integer[] array = RandomUtils.generateRandomIntegerArray(size, origin, bound);
        Assert.assertNotNull(array);
        Assert.assertEquals(size, array.length);
        Assert.assertThat(Arrays.asList(array), Matchers.everyItem(Matchers.allOf(Matchers.greaterThanOrEqualTo(origin), Matchers.lessThan(bound))));
    }
}