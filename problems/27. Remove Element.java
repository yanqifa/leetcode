class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int ans = len;
        for(int i = 0; i < ans; i++){
            while(nums[i] == val && i < ans){
                for(int j = i; j < ans - 1; j++){
                    nums[j] = nums[j+1];
                }
                ans--;
            }
        } 
        return ans;
    }
}