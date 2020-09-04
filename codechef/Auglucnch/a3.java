import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int dp[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            dp[0]= a[0]==1?0:1;
            int max=-1;
            max = Math.max(max,dp[0]);
            for(int i=1;i<n;i++)
            {
                if(a[i]==0)
                dp[i]=dp[i-1]+1;
                max = Math.max(max,dp[i]);
            }
            if(max%2==0)
            System.out.println("No");
            else
            System.out.println("Yes");

        }
    }
}