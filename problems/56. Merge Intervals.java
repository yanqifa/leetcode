import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        //sort
        if(intervals.length <= 1)return intervals;
        Arrays.sort(intervals, (arr1,arr2)->Integer.compare(arr1[0],arr2[0]));
        LinkedList<int[]> mergeList = new LinkedList<>();
        for(int[] interval : intervals){
            if(mergeList.isEmpty() || mergeList.getLast()[1] < interval[0]){
                mergeList.add(interval);
            }else{
                mergeList.getLast()[1] = Math.max(mergeList.getLast()[1], interval[1]);
            }
        }
        return mergeList.toArray(new int[mergeList.size()][]);
    }
}