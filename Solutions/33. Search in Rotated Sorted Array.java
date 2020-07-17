class Solution {
    public int search(int[] nums, int target)
     {
        int len = nums.length;
        return searchCore(0, len - 1, nums, target);
    }

    private int searchCore(int start, int end, int[] nums, int target)
    {
        if(start > end) return -1;
        int mid = (start + end)/2;
        if(target == nums[mid])return mid;
        //nums[mid]在左边有序
        if(nums[mid] >= nums[start]){
            if(target < nums[mid] && target >= nums[start]) return searchCore(start, mid - 1, nums, target); 
            else return searchCore(mid + 1, end, nums, target);
        }else{ //nums[mid]在右边有序
            if(target > nums[mid] && target <= nums[end])return searchCore(mid + 1, end, nums, target);
            else return searchCore(start, mid - 1, nums, target); 
        }
    }
}