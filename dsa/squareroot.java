import java.util.*;
public class squareroot {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int ans=mySqrt(n);
        System.out.println(ans);
        t.close();
    }
    public static int mySqrt(int x) {
        int start=0;
        int end=x;
        double ans=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid*mid==x)
            {
                ans=mid;
                break;
            }
            if(mid*mid>x)
            {
                end=mid-1;
            }
            else
            {
               start=mid+1;
               ans=mid;
            }
        }
        double increment=0.1;
        while (ans * ans <x){
            ans += increment;
        }

        // loop terminates when ans * ans > number
        //ans = ans - increment;
        increment = increment / 10;
        return (int)ans;
    }
}
