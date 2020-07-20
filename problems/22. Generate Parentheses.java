import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) 
    {
        dfs("", 0, 0, n);
        return ans;
    }

    private void dfs(String str, int l, int r, int n)
    {
        if(l == n && r == n){
            ans.add(str);
            return;
        }
        if(l < r) return;
        if(l < n) dfs(str + "(", l + 1, r, n);
        if(r < n) dfs(str + ")", l, r + 1, n);
    }
}