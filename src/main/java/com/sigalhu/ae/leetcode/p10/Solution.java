package com.sigalhu.ae.leetcode.p10;

/**
 * @author huxujun
 * @date 2019-05-29
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int pp = p.length() - 1; pp >= 0; --pp) {
            dp[s.length()][pp] = pp + 1 < p.length() && p.charAt(pp + 1) == '*' && dp[s.length()][pp + 2];
        }
        boolean match;
        for (int ss = s.length() - 1; ss >= 0; --ss) {
            for (int pp = p.length() - 1; pp >= 0; --pp) {
                match = s.charAt(ss) == p.charAt(pp) || p.charAt(pp) == '.';
                dp[ss][pp] = (pp + 1 < p.length() && p.charAt(pp + 1) == '*') ?
                        (dp[ss][pp + 2] || (match && dp[ss + 1][pp])) :
                        match && dp[ss + 1][pp + 1];
            }
        }
        return dp[0][0];
    }
}
