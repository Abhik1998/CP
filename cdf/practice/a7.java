import java.util.*;
public class a7{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long mod = 998244353;
        for(int i=1;i<n;i++){
            long f = ((long)180 * (long)Math.pow(10,n-i-1)%mod)%mod;
            long s = ((long)810 * ((n-i-1)%mod*(long)Math.pow(10,n-i-2)%mod)%mod)%mod;
            s = (long)(s%mod + f%mod);
            System.out.print(s+" ");
        }
        System.out.println(10);

        

    }
}