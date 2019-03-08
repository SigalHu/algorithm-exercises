package com.sigalhu.ae.algorithm;

import com.sigalhu.ae.utils.ArrayUtils;
import com.sigalhu.ae.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SortTest {

    private Integer[] array;

    @Before
    public void setUp() throws Exception {
        array = RandomUtils.generateRandomIntegerArray(10, -100, 100);
    }

    @Test
    public void bubbleSort() {
        Integer[] testArray = Sort.bubbleSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void bubbleSortV2() {
        Integer[] testArray = Sort.bubbleSortV2(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void quickSort() {
        Integer[] testArray = Sort.quickSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void quickSortV2() {
        Integer[] testArray = Sort.quickSortV2(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void selectionSort() {
        Integer[] testArray = Sort.selectionSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void selectionSortV2() {
        Integer[] testArray = Sort.selectionSortV2(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void heapSort() {
        Integer[] testArray = Sort.heapSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void insertionSort() {
        Integer[] testArray = Sort.insertionSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void shellSort() {
        Integer[] testArray = Sort.shellSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void shellSortV2() {
        Integer[] testArray = Sort.shellSortV2(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void mergeSort() {
        Integer[] testArray = Sort.mergeSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }

    @Test
    public void radixSort() {
        Integer[] testArray = Sort.radixSort(array.clone());
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(testArray));
        Assert.assertTrue(ArrayUtils.isSorted(testArray));
    }
}