package com.sigalhu.ae.leetcode.p4;

/**
 * @author huxujun
 * @date 2019-05-18
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid0 = findMinKSortedArrays((total + 1) / 2, nums1, 0, nums1.length, nums2, 0, nums2.length);
        return (nums1.length + nums2.length) % 2 == 1 ? mid0 :
                (mid0 + findMinKSortedArrays(total / 2 + 1, nums1, 0, nums1.length, nums2, 0, nums2.length)) / 2.0;
    }

    private int findMinKSortedArrays(int k, int[] nums1, int start1, int length1, int[] nums2, int start2, int length2) {
        if (length1 > length2) {
            return findMinKSortedArrays(k, nums2, start2, length2, nums1, start1, length1);
        } else if (length1 == 0) {
            return nums2[start2 + k - 1];
        } else if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int k1 = Math.min(length1, k / 2);
        int k2 = k - k1;
        if (nums1[start1 + k1 - 1] < nums2[start2 + k2 - 1]) {
            return findMinKSortedArrays(k - k1, nums1, start1 + k1, length1 - k1, nums2, start2, k2);
        } else if (nums1[start1 + k1 - 1] > nums2[start2 + k2 - 1]) {
            return findMinKSortedArrays(k - k2, nums1, start1, k1, nums2, start2 + k2, length2 - k2);
        } else {
            return nums1[start1 + k1 - 1];
        }
    }
}
