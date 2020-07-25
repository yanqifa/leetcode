import java.util.*;

class KthLargest {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums){
            add(n);
        }
    }
 
    public int add(int val) {
        if(q.size() < k){
            q.offer(val);
        }else{
            int i = q.peek();
            if(val > i){
                q.poll();
                q.offer(val);
            }
        }
        return q.peek();
    }
}