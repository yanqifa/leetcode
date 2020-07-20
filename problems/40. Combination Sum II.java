import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
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
                if(i != start && candidates[i] == candidates[i-1])continue;
                tempList.add(candidates[i]);
                backtrace(tempList, candidates, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}