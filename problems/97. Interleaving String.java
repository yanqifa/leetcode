class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        //todo
        return false;
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