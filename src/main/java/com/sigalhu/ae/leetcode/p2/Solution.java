package com.sigalhu.ae.leetcode.p2;

/**
 * @author huxujun
 * @date 2019-05-05
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode head = new ListNode(val % 10), tail = head;
        val /= 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            val += (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            tail.next = new ListNode(val % 10);
            val /= 10;
            tail = tail.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (val > 0) {
            tail.next = new ListNode(val);
        }
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
