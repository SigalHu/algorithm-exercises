package com.sigalhu.ae.structure.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {

    Integer[] array;
    private BinarySearchTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        array = new Integer[]{56, -47, -57, -20, -85, -14, 10, -40, 94, -27};
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

    @Test
    public void breadthFirstTraversal() {
        List<Integer> list = new ArrayList<>(array.length);
        tree.breadthFirstTraversal(list::add);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(list.toArray()));
    }

    @Test
    public void depthFirstTraversal() {
        List<Integer> list = new ArrayList<>(array.length);
        tree.depthFirstTraversal(list::add);
        System.err.println(Arrays.toString(array));
        System.err.println(Arrays.toString(list.toArray()));
    }
}