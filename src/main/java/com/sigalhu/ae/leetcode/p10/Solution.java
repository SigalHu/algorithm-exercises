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
        int ss = 0, pp = 0;
        while (ss < s.length() && pp < p.length()) {
            if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
                if (s.charAt(ss) == p.charAt(pp)) {
                    int sstmp = ss + 1, pptmp = pp + 2;
                    while (sstmp < s.length() && s.charAt(sstmp) == s.charAt(ss)) {
                        sstmp++;
                    }
                    while (pptmp < p.length() && p.charAt(pptmp) == p.charAt(pp)) {
                        pptmp++;
                    }
                    if (sstmp - ss >= pptmp - pp - 1) {
                        ss = sstmp;
                        pp = pptmp;
                    } else {
                        return false;
                    }
                } else if (p.charAt(pp) == '.') {
                    if ((pp += 2) == p.length()) {
                        return true;
                    }
                    while (ss < s.length() && s.charAt(ss) != p.charAt(pp)) {
                        ss++;
                    }
                } else {
                    pp += 2;
                }
            } else if (s.charAt(ss) == p.charAt(pp) || p.charAt(pp) == '.') {
                ss++;
                pp++;
            } else {
                return false;
            }
        }
        return ss == s.length() && pp == p.length();
    }

    public static void main(String[] args) {
        System.err.println(new Solution().isMatch("aaa", "ab*a*c*a"));
    }
}
