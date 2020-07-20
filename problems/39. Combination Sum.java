import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<Integer> tempList = new ArrayList<>();
        backtrace(tempList, candidates, target, 0);
        return ans;
    }

    private void backtrace(List<Integer> tempList, int[] candidates, int remain, int start)
    {
        if(remain < 0)return;
        else if(remain == 0)ans.add(new ArrayList<>(tempList));
        else
        {
            for(int i = start; i < candidates.length; i++)
            {
                tempList.add(candidates[i]);
                backtrace(tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}