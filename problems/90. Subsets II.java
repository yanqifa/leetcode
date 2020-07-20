import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        List<List<Integer>> subsets = new ArrayList<>();
        if(nums.length == 0)return subsets;
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int oldSize = 1; 
        int last = nums[0]; 
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != last){
                oldSize = subsets.size();
                last = nums[i];
            }
            int size = subsets.size();
            for(int j = size - oldSize; j < size; j++)
            {
                List<Integer> newSubset = new ArrayList<Integer>(subsets.get(j));
                newSubset.add(nums[i]);
                subsets.add(newSubset);
            }
        }
        return subsets;
    }
}
