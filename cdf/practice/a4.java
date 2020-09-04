import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            int dp[]=new int[n];
            //HashMap<Integer,Integer> h=new HashMap<>();
            int l[][]=new int[n][26];
            int r[][]=new int[n][26];
            l[0][a[0]-1]=1;
            r[n-1][a[n-1]-1]=1;
            for(int i=1;i<n;i++)
                for(int j=0;j<26;j++)
                l[i][j]=l[i-1][j] + (j+1)==a[i]?1:0;
            for(int i=n-2;i>=0;i--)
                for(int j=0;j<26;j++)
                r[i][j]=r[i+1][j] + (j+1)==a[i]?1:0;
            dp[0]=1;
            dp[n-1]=1;
            int max=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<26;j++)
                dp[i] = Math.max(dp[i],((i>0)?l[i-1][j]:0)+((i<n-1)?r[i+1][j]:0)+1);
                max = Math.max(dp[i],max);
            }
            System.out.println(max);
        }
    }
}