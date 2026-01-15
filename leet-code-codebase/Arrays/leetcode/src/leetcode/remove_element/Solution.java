package leetcode.remove_element;

class Solution {

    public int removeElement(int[] nums, int val) {
        int k = 0; 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int k = s.removeElement(nums, val);

        System.out.print("k = " + k + ", nums = ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}