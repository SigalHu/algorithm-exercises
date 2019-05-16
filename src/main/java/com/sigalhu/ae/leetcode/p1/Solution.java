package com.sigalhu.ae.leetcode.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huxujun
 * @date 2019-05-05
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0, j; i < nums.length; i++) {
            if (map.containsKey(j = target - nums[i])) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
