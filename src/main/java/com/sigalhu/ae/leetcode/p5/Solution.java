package com.sigalhu.ae.leetcode.p5;

/**
 * @author huxujun
 * @date 2019-05-19
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }

        int rightIndex = 0, centerIndex = 0, max = 0, index = 0;
        int[] len = new int[sb.length()];
        for (int i = 1; i < sb.length(); i++) {
            len[i] = rightIndex > i ? Math.min(rightIndex - i, len[2 * centerIndex - i]) : 1;
            while (i - len[i] >= 0 && i + len[i] < sb.length() && sb.charAt(i - len[i]) == sb.charAt(i + len[i])) {
                len[i]++;
            }

            if (len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if (len[i] > max) {
                max = len[i];
                index = i;
            }
        }
        return sb.substring(index - max + 1, index + max).replace("#", "");
    }
}
