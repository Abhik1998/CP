import java.util.*;
public class b{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int h[]=new int[n];
        for(int i=0;i<n;i++)
        h[i]=sc.nextInt();
        int dp[]=new int[n];dp[0]=0;dp[1]=Math.abs(h[1]-h[0]);
        for(int i=2;i<Math.min(k,n);i++)
            dp[i]=Math.abs(h[i]-h[0]);
        for(int i=k;i<n;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=i-k;j<i;j++)
            min=Math.min(min,dp[j]+Math.abs(h[i]-h[j]));
            dp[i]=min;
        }
        System.out.println(dp[n-1]);
        
        sc.close();
    }
}