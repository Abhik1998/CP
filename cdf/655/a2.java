import java.math.BigInteger;
import java.util.*;
public class a2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            if(n%2==0)
            {
                System.out.println(n/2 + " " +n/2);
                continue;
            }
            int k=0;
            if(isprime(n))
            {
                System.out.println((n-1)+" "+1);
                continue;
            }
            for(int i=3;i<=n;i+=2)
            if(n%i==0){
                k=i;
                break;
            }
            int a = n/k;
            int b = (k-1) * a;
            System.out.println(a+" "+b);

        }
        sc.close();
    }
    public static boolean isprime(int n){
        BigInteger a=new BigInteger(Integer.toString(n));
        return a.isProbablePrime(1);
    }
}