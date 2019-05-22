package com.sigalhu.ae.leetcode.p9;

/**
 * @author huxujun
 * @date 2019-05-21
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else if (x % 10 == 0) {
            return false;
        }
        int y = 0;
        do {
            y = y * 10 + x % 10;
            if (x == y) {
                return true;
            }
        } while ((x /= 10) > y);
        return x == y;
    }
}
