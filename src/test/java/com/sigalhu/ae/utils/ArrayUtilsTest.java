package com.sigalhu.ae.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sigalhu
 * @date 2019/4/16
 */
public class ArrayUtilsTest {

    @Test
    public void isEmpty() {
        Assert.assertTrue(ArrayUtils.isEmpty(new Object[0]));
        Assert.assertFalse(ArrayUtils.isEmpty(new Object[1]));
    }

    @Test
    public void swap() {
        Assert.assertArrayEquals(new Integer[]{1, 2}, ArrayUtils.swap(new Integer[]{2, 1}, 0, 1));
    }

    @Test
    public void isSorted() {
        Assert.assertTrue(ArrayUtils.isSorted(new Integer[]{1, 2, 3, 3, 5}));
        Assert.assertFalse(ArrayUtils.isSorted(new Integer[]{1, 2, 3, 5, 3}));
    }
}