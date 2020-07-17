class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int[] dp = new int[len + 1];
        
        for(int i = 1; i < len + 1; i++){
            if(i == 1) {
                if(isValid(s.substring(0, 1)))dp[i] = 1;
                else dp[i] = 0;
            }
            else if(i == 2) {
                int num = 0;
                if(isValid(s.substring(0, 1)) && isValid(s.substring(1, 2)))num++;
                if(isValid(s.substring(0,2)))num++;
                dp[i] = num;
            }else{
                int num = 0;
                if(isValid(s.substring(i - 1, i)))num += dp[i - 1];
                if(isValid(s.substring(i - 2, i)))num += dp[i - 2];
                dp[i] = num;
            }
        }
        return dp[len];

    }

    private boolean isValid(String s){
        if(s.length() == 2 && s.substring(0, 1).equals("0"))return false;
        int num = Integer.parseInt(s);
        if(num >= 1 && num <= 26) return true;
        return false;
    }
}