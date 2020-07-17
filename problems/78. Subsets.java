/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
import java.util.Arrays;
import java.util.List;
class Solution {

    //递归
    // public List<List<Integer>> subsets(int[] nums) {
    //     if(nums.length == 0){
    //         List<List<Integer>> ans = new ArrayList<>();
    //         List<Integer> subset = new ArrayList<>();
    //         ans.add(subset);
    //         return ans;
    //     }
    //     int n = nums.length;
    //     int i = nums[n - 1];
    //     int[] preNums = Arrays.copyOfRange(nums, 0, n - 1); 
    //     List<List<Integer>> preSubsets = subsets(preNums);
    //     List<List<Integer>> ans = new ArrayList<>(preSubsets);
    //     for(List<Integer> subset : preSubsets)
    //     {
    //         List<Integer> newSubset = new ArrayList<Integer>(subset);
    //         newSubset.add(i);
    //         ans.add(newSubset);
    //     }
    //     return ans;
    // }

    //迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(int i : nums)
        {
            int size = subsets.size();
            for(int j = 0; j < size; j++)
            {
                List<Integer> newSubset = new ArrayList<Integer>(subset.get(j));
                newSubset.add(i);
                subsets.add(newSubset);
            }
        }
        return subsets;
    }
}