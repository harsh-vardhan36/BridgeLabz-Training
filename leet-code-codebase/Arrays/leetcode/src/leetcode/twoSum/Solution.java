package leetcode.twoSum;

import java.util.HashMap;
import java.util.Arrays;
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = s.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
    
}

