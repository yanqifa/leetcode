class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < len; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) dp[i] = dp[j] + 1;
            }
            if(dp[i] > max) max = dp[i];
        }
        return max;

    }
}