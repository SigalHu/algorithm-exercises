package com.sigalhu.ae.leetcode.p2;

/**
 * @author huxujun
 * @date 2019-05-05
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        ListNode head = new ListNode(val % 10);
        ListNode tail = head;
        val /= 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            val += l1.val + l2.val;
            tail.next = new ListNode(val % 10);
            val /= 10;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            do {
                val += l1.val;
                tail.next = new ListNode(val % 10);
                val /= 10;
                tail = tail.next;
            } while ((l1 = l1.next) != null);
        } else if (l2 != null) {
            do {
                val += l2.val;
                tail.next = new ListNode(val % 10);
                val /= 10;
                tail = tail.next;
            } while ((l2 = l2.next) != null);
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
