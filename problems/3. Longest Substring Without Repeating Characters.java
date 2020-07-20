import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                int len = j - i + 1;
                max = Math.max(len, max);
                j++;

            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
        
    }
}