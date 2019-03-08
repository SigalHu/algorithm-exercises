package com.sigalhu.ae.algorithm;

import com.sigalhu.ae.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SearchTest {

    private Integer[] array;

    @Before
    public void setUp() throws Exception {
        array = RandomUtils.generateRandomIntegerArray(10, 100);
        Arrays.sort(array);
    }

    @Test
    public void binarySearch() {
        int idx = 6;
        int testIdx = Search.binarySearch(array, array[6]);
        System.err.println(Arrays.toString(array));
        Assert.assertEquals(array[idx], array[testIdx]);
    }
}