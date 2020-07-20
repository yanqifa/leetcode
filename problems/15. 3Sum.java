import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < len - 2; i++)
        {
            if(nums[i] > 0)break;
            if(i > 0 && nums[i] == nums[i-1])continue;
            int l = i + 1;
            int r = len - 1;
            while(l < r)
            {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[l]);
                    pair.add(nums[r]);
                    ans.add(pair);
                    while(nums[l] == nums[++l] && nums[r] == nums[--r] && l < r);
                }
                else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return ans;
    }
}