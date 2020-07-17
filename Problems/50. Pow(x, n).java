class Solution {
    //会超时！！！
    // public double myPow(double x, int n) {
    //     double ans = 1;
    //     if(n >= 0){
    //         while(n-- > 0){ans *= x;}
    //         return ans;
    //     }else{
    //         while(n++ < 0){ans *= x;}
    //         return 1/ans;
    //     }
    // }

    //折半递归
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double half = myPow(x, n/2);
        if(n % 2 == 0) return half * half;
        if(n > 0) return half * half * x;
        else return half * half / x;
    }
}