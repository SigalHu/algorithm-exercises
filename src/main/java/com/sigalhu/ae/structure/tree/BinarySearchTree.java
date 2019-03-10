package com.sigalhu.ae.structure.tree;

import java.util.function.Consumer;

/**
 * @author sigalhu
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public void add(T value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            addNode(root, node);
        }
    }

    private void addNode(Node root, Node node) {
        if (root.compareTo(node) > 0) {
            if (root.left == null) {
                root.left = node;
            } else {
                addNode(root.left, node);
            }
        } else if (root.compareTo(node) < 0) {
            if (root.right == null) {
                root.right = node;
            } else {
                addNode(root.right, node);
            }
        } else {
            node.left = root.left;
            root.left = node;
        }
    }

    /**
     * 前序遍历
     *
     * @param consumer
     */
    public void preorderTraversal(Consumer<T> consumer) {
        preorderTraversal(root, consumer);
    }

    private void preorderTraversal(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        preorderTraversal(node.left, consumer);
        preorderTraversal(node.right, consumer);
    }

    /**
     * 中序遍历
     *
     * @param consumer
     */
    public void inorderTraversal(Consumer<T> consumer) {
        inorderTraversal(root, consumer);
    }

    private void inorderTraversal(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, consumer);
        consumer.accept(node.value);
        inorderTraversal(node.right, consumer);
    }

    /**
     * 后序遍历
     *
     * @param consumer
     */
    public void postorderTraversal(Consumer<T> consumer) {
        postorderTraversal(root, consumer);
    }

    private void postorderTraversal(Node node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, consumer);
        postorderTraversal(node.right, consumer);
        consumer.accept(node.value);
    }

    protected class Node implements Comparable<Node> {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return value.compareTo(o.value);
        }
    }
}
