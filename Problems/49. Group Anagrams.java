import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> tempList = map.get(key);
            if(tempList == null)
            {
                map.put(key, new ArrayList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> value : map.values())
        {
            ans.add(value);
        }
        return ans;
    }
}