class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n)
        {
            if(nums1[i] < nums2[j])
            {
                nums3[k++] = nums1[i++];
            }
            else
            {
                nums3[k++] = nums2[j++];
            }
        }
        while(i < m) nums3[k++] = nums1[i++];
        while(j < n) nums3[k++] = nums2[j++];
        if((m + n) % 2 == 1)return nums3[(m + n)/2];
        else return ((double)nums3[((m + n)/2 - 1)] + (double)nums3[(m + n)/2])/2;
    }
}