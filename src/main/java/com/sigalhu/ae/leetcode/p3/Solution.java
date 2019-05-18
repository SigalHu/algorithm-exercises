package com.sigalhu.ae.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huxujun
 * @date 2019-05-18
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(s.length());
        int maxLen = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                continue;
            }
            maxLen = Math.max(maxLen, set.size());
            while (s.charAt(left) != s.charAt(right)) {
                set.remove(s.charAt(left++));
            }
            set.remove(s.charAt(left++));
            set.add(s.charAt(right));
        }
        return Math.max(maxLen, set.size());
    }
}
