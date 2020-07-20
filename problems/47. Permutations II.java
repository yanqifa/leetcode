import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrace(new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return ans;
    }

    private void backtrace(List<Integer> tempList, int[] nums, boolean[] visits, int start)
    {
        if(start == nums.length)
        {
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(visits[i])continue;
            if(i != 0 && nums[i] == nums[i - 1] && visits[i - 1])continue;
            visits[i] = true;
            tempList.add(nums[i]);
            backtrace(tempList, nums, visits, start + 1);
            tempList.remove(tempList.size() - 1);
            visits[i] = false;
        }
    }
}