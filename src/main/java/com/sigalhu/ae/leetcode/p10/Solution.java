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
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int ss, int pp) {
        while (ss < s.length() && pp < p.length()) {
            if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
                break;
            } else if (s.charAt(ss) == p.charAt(pp) || p.charAt(pp) == '.') {
                ss++;
                pp++;
            } else {
                return false;
            }
        }
        if (ss == s.length() || pp == p.length()) {
            while (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
                pp += 2;
            }
            return ss == s.length() && pp == p.length();
        }
        if (p.charAt(pp) == '.') {
            while (ss < s.length()) {
                if (isMatch(s, p, ss++, pp + 2)) {
                    return true;
                }
            }
            return isMatch(s, p, ss, pp + 2);
        }
        while (ss < s.length() && s.charAt(ss) == p.charAt(pp)) {
            if (isMatch(s, p, ss++, pp + 2)) {
                return true;
            }
        }
        return isMatch(s, p, ss, pp + 2);
    }
}
