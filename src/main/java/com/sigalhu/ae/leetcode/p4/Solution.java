package com.sigalhu.ae.leetcode.p4;

/**
 * @author huxujun
 * @date 2019-05-18
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        return findMinKSortedArrays((total + 1) / 2, total % 2 == 0, nums1, 0, nums1.length, nums2, 0, nums2.length);
    }

    private double findMinKSortedArrays(int k, boolean isEven, int[] nums1, int start1, int length1, int[] nums2, int start2, int length2) {
        if (length1 > length2) {
            return findMinKSortedArrays(k, isEven, nums2, start2, length2, nums1, start1, length1);
        } else if (length1 == 0) {
            return isEven ? (nums2[start2 + k - 1] + nums2[start2 + k]) / 2.0 : nums2[start2 + k - 1];
        } else if (k == 1) {
            if (isEven) {
                return nums1[start1] < nums2[start2] ?
                        (nums1[start1] + findMinKSortedArrays(1, false, nums1, start1 + 1, length1 - 1, nums2, start2, length2)) / 2.0 :
                        (nums2[start2] + findMinKSortedArrays(1, false, nums1, start1, length1, nums2, start2 + 1, length2 - 1)) / 2.0;
            } else {
                return Math.min(nums1[start1], nums2[start2]);
            }
        }

        int k1 = Math.min(length1, k / 2);
        int k2 = k - k1;
        if (nums1[start1 + k1 - 1] < nums2[start2 + k2 - 1]) {
            return findMinKSortedArrays(k - k1, isEven, nums1, start1 + k1, length1 - k1, nums2, start2, length2);
        } else if (nums1[start1 + k1 - 1] > nums2[start2 + k2 - 1]) {
            return findMinKSortedArrays(k - k2, isEven, nums1, start1, length1, nums2, start2 + k2, length2 - k2);
        } else {
            return findMinKSortedArrays(1, isEven, nums1, start1 + k1 - 1, length1 - k1 + 1, nums2, start2 + k2, length2 - k2);
        }
    }

    public static void main(String[] args) {
        System.err.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}
