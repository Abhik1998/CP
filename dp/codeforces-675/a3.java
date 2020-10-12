import java.util.*;
  

public class a3 
{ 

    
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        long sum =0,mod=1000000007;
            //int a[]=new int[n];
            char ch[]=sc.next().toCharArray();
            int n=ch.length;
            long p[]=new long[n];
            p[0]=1;
            for(int i=1;i<n;i++)
            p[i] = ((long)p[i-1]%mod *10)%mod;
            long dp[]=new long[n];
            dp[0]=1;
            for(int i=1;i<n;i++)
                dp[i] = ((long)dp[i-1] + ((long)p[i] * i)%mod)%mod;
            for(int i=0;i<n;i++)
            sum = sum + 
            
        
            for(int i=0;i<n;i++)
                sum  = sum%mod;
                
            System.out.println(sum);
            sc.close();
        
    }
    //public static int pow(int x,int pow)

}