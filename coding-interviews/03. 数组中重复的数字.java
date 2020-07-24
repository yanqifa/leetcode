class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i : nums){
            arr[i]++;
            if(arr[i] > 1)return i;
        }
        return -1;
    }
}