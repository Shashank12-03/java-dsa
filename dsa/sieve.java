import java.util.*;
public class sieve {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        boolean[] primes= new boolean[n+1];
        // System.out.println(primes[0]);
        Sieve(n,primes);
        t.close();
    }
    static void Sieve(int a, boolean[] primes)
    {
        for(int i=2;i*i<=a;i++)
        {
            if(!primes[i]){
                for(int j=i*2;j<=a;j+=i)
                {
                    primes[j]=true;
                }
            }
        }
        for(int i=2;i<=a;i++)
        {
            if(!primes[i]){
                System.out.println(i+" ");
            }
        }
    }
}
