import java.util.*;
public class h{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt(),w=sc.nextInt(),mod=1000000007;
        char a[][]=new char[h][w];
        int dp[][]=new int[h][w];
        for(int i=0;i<h;i++)
            a[i]=sc.next().toCharArray();
        dp[0][0]=1;
        for(int i=1;i<w;i++)
        if(a[0][i]=='.')
        dp[0][i]=dp[0][i-1];
        for(int i=1;i<h;i++)
        if(a[i][0]=='.')
        dp[i][0]=dp[i-1][0];
        for(int i=1;i<h;i++)
            for(int j=1;j<w;j++)
            if(a[i][j]=='.')
            dp[i][j]=(int)((long)(dp[i-1][j])%mod+(dp[i][j-1])%mod)%mod;
        System.out.println(dp[h-1][w-1]);
        sc.close();
    }
}
// 3 4
// ...#
// .#..
// ....