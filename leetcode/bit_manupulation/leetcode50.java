package bit_manupulation;

public class leetcode50 {
    public static void main(String[] args) {
        
    }
    public double myPow(double x, int n) {
        //    if (x==1.0) return 1;
        //     if (x==-1){
        //         if (n%2 == 0) return 1.0;
        //         else return -1.0;
        //     }
        //     if(x==1.0000000000001 && n<-2147483647) return 0.99979;
        //     if (x>1.0000000000001 && n<-2147483647) return 0;
        //     double res = 1;
        //     int t;
        //     if (n>=0) t=n;
        //     else t=n*(-1);
        //     while(t>0){
        //         res*=x; 
        //         t--;
        //     }
        //     if (n>=0)
        //     return res;
        //     return 1/res;
        double ans=1;
        while(n>0){
            if((n&1)==1){
                ans*=x;
            }
            x*=x;
            n=n>>1;
        }
        return ans;
    }
}
