package sorting;
public class gfgsumRecursion {
    public static void main(String[] args) {
        int n=1244;
        int sum=0;
        System.out.println(sumno(n,sum));
    }
    static int sumno(int n,int sum){
        // while(n!=0){
        //    sum+=n%10;
        //    n=n/10;
        // }
        // return sum;
        if(n==0){
            return sum;
        }
        else{
            return sumno(n/10, sum+(n%10));
        }
    }
}
