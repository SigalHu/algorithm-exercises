package com.sigalhu.ae.leetcode.p8;

/**
 * @author huxujun
 * @date 2019-05-21
 */
public class Solution {

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int idx = 0;
        while (idx < str.length() && str.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == str.length()) {
            return 0;
        }
        boolean isNegative = false;
        if (str.charAt(idx) == '-') {
            isNegative = true;
            idx++;
        } else if (str.charAt(idx) == '+') {
            idx++;
        }
        if (idx == str.length() || str.charAt(idx) < '0' || str.charAt(idx) > '9') {
            return 0;
        }
        long num = 0;
        while (idx < str.length() && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
            num = num * 10 + (str.charAt(idx++) - '0');
            if ((num & Integer.MIN_VALUE) != 0) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return (int) (isNegative ? -num : num);
    }
}
