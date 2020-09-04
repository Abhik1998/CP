import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            long k=sc.nextLong();
            int c = (int)k%2;
            int a[]=new int[n];
            int d[]=new int[n-1];
            a[0]=sc.nextInt();
            int min=a[0],max=a[0],mini=0,maxi=0;
            for(int i=1;i<n;i++)
            {
                a[i]=sc.nextInt();
                d[i-1]=a[i]-a[i-1];
                if(min>a[i])
                {
                    min=a[i];
                    mini=i;
                }
                if(max<a[i])
                {
                    max=a[i];
                    maxi=i;
                }
            }
            int fl=1;
            if(c==1)
            fl=-1;
            c = (c==0)?mini:maxi;
            int dp[]=new int[n];
            dp[c]=0;
            for(int i=c+1;i<n;i++)
            dp[i]=dp[i-1] + d[i-1];
            for(int i=c-1;i>=0;i--)
            dp[i] = dp[i+1] - d[i];
            for(int i=0;i<n;i++)
            System.out.print(Math.abs(dp[i])+" ");
            System.out.println();


        }
    }
}