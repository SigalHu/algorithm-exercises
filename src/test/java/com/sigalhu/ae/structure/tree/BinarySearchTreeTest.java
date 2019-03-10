package com.sigalhu.ae.structure.tree;

import com.sigalhu.ae.utils.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    Integer[] array;
    private BinarySearchTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        array = RandomUtils.generateRandomIntegerArray(10, -100, 100);
        tree = new BinarySearchTree<>();
        for (Integer value : array) {
            tree.add(value);
        }
    }

    @Test
    public void inorderTraversal() {
        List<Integer> list = new ArrayList<>(array.length);
        tree.inorderTraversal(list::add);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void preorderTraversal() {
        List<Integer> list = new ArrayList<>(array.length);
        tree.preorderTraversal(list::add);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void postorderTraversal() {
        List<Integer> list = new ArrayList<>(array.length);
        tree.postorderTraversal(list::add);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(list.toArray()));
    }
}