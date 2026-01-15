package leetcode.remove_duplicates_sorted_array;

class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 1, 2, 2, 3};
        int k = s.removeDuplicates(nums);

        System.out.print("k = " + k + ", nums = ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
