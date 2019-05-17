package com.sigalhu.ae.leetcode.p2;

/**
 * @author huxujun
 * @date 2019-05-05
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, tail = new ListNode(0);
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                l1.val += l2.val + tail.val / 10;
            } else if (l1 != null) {
                l1.val += tail.val / 10;
            } else {
                tail.next = l1 = l2;
                l2 = null;
                continue;
            }
            tail.val %= 10;
            l1 = (tail = l1).next;
            l2 = l2 == null ? null : l2.next;
        }
        if (tail.val / 10 > 0) {
            tail.next = new ListNode(tail.val / 10);
            tail.val %= 10;
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
