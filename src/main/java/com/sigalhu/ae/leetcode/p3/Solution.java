package com.sigalhu.ae.leetcode.p3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huxujun
 * @date 2019-05-18
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        int maxLen = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right)) || map.get(s.charAt(right)) < left) {
                map.put(s.charAt(right), right++);
                continue;
            }
            maxLen = Math.max(maxLen, right - left);
            left = map.get(s.charAt(right)) + 1;
            map.put(s.charAt(right), right++);
        }
        return Math.max(maxLen, right - left);
    }

    public static void main(String[] args) {
        System.err.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
