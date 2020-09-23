import java.util.*;
public class e{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),W=sc.nextInt(),sum=0;
        int w[]=new int[n];
        int v[]=new int[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
            sum+=v[i];
        }      long dp[]=new long[sum+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=sum;j>=v[i];j--)
                dp[j]=Math.min(dp[j],(long)dp[j-v[i]]+w[i]);

        }
        for(int i=sum;i>=0;i--)
        if(dp[i]<=W)
        {
            System.out.println(i);
            break;
        }
        sc.close();
    }
}