class Solution {
    public int maxArea(int[] height) 
    {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while(i != j)
        {
            int h = height[i] < height[j] ? height[i++]:height[j--];
            int area = h * (j - i + 1);
            maxArea = area > maxArea ? area : maxArea; 
        }
        return maxArea;
    }
}