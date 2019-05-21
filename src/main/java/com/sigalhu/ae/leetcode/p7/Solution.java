package com.sigalhu.ae.leetcode.p7;

/**
 * @author huxujun
 * @date 2019-05-21
 */
public class Solution {

    public int reverse(int x) {
        long y = 0;
        boolean isNegative = x < 0;
        if (isNegative) {
            x *= -1;
        }
        do {
            y = y * 10 + x % 10;
        } while ((x /= 10) > 0);
        return (y & 0xffffffff80000000L) == 0 ? (int) (isNegative ? -y : y) : 0;
    }
}
