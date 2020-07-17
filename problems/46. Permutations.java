class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrace(new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtrace(List<Integer> tempList, int[] nums, int start){
        if(start == nums.length) ans.add(new ArrayList<>(tempList));
        else{
            for(int n : nums)
            {
                boolean isExit = false;
                for(int x : tempList){if(x == n)isExit = true;}
                if(isExit)continue;
                tempList.add(n);
                backtrace(tempList, nums, start+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}