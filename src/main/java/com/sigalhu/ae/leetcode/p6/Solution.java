package com.sigalhu.ae.leetcode.p6;

/**
 * @author huxujun
 * @date 2019-05-21
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = numRows + (numRows - 2), m;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && (m = j - i + step - i) < s.length()) {
                    sb.append(s.charAt(m));
                }
            }
        }
        return sb.toString();
    }
}
