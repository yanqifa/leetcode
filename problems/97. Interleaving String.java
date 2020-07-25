class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        //init
        for(int i = 1; i < len1 + 1; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }

        for(int j = 1; j < len2 + 1; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) dp[0][j] = true;
            else break;
        }

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if((dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j -1)))dp[i][j] = true;
            }
        }
        return dp[len1][len2];
    }
    
    //TLE
    public boolean isInterleave1(String s1, String s2, String s3) {
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())return true;
        if(s3.isEmpty())return false;
        boolean s1b = false;
        boolean s2b = false;
        if(!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) s1b = isInterleave1(s1.substring(1), s2, s3.substring(1));
        if(!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) s2b = isInterleave1(s1, s2.substring(1), s3.substring(1));
        return s1b || s2b;
    }
}