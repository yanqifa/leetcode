class Solution {
// would time exceed!
//     public boolean canJump(int[] nums) {
//         return dfs(nums, 0);
//     }

//     private boolean dfs(int[] nums, int index){
//         if(index >= nums.length - 1) return true;
//         if(nums[index] == 0) return false;
//         boolean canJump = false;
//         for(int i = 1; i <= nums[index]; i++){
//             if(dfs(nums, index + i))canJump = true;
//         }
//         return canJump;
//     }
        public boolean canJump(int[] nums) {
            int len = nums.length;
            boolean[] dp = new boolean[len];
            dp[0] = true;
            for(int i = 0; i < len; i++){
                for(int j = 1; j <= nums[i]; j++){
                    if(dp[i] && i + j < len)dp[i + j] = true;
                }
            }
            return dp[len - 1];
        }
 }