class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0)return "";
        int l = 0;
        int r = 0;
        boolean[][] dp = new boolean[n][n];
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1] == true)){
                    dp[i][j]=true;
                    if(j - i > r - l){
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}