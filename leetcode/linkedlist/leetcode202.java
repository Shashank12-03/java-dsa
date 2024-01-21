package linkedlist;

public class leetcode202 {
    public static void main(String[] args) {
        System.out.println(isHappy(12));
    }
    public static boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=sqhap(slow);
            fast=sqhap(sqhap(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        else{
            return false;

        }
    }
    public static int sqhap(int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
}
