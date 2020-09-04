import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int t1=t;
        while(t-->0){
            int n=sc.nextInt();
            char chi[]=sc.next().toCharArray();
            char cho[]=sc.next().toCharArray();
            boolean dp[][]=new boolean[n][n];
            dp[0][0]=true;
            if(cho[0]=='Y')
            for(int i=1;i<n;i++)
            {
                if(chi[i]=='Y')
                dp[0][i]=dp[0][i-1]&&(cho[i-1]=='Y');
            }
            for(int i=0;i<n;i++)
            dp[i][i]=true;

            for(int i=1;i<n;i++)
            dp[i][0]=dp[i-1][0]&&chi[0]=='Y'&&cho[i]=='Y'&&chi[i-1]=='Y';

            for(int i=1;i<n;i++)
            {
                
                for(int j=1;j<n;j++)
                {
                    //if(j>0)
                    dp[i][j] = dp[i][j] || (dp[i][j-1]&&(chi[j]=='Y')&&(cho[j-1]=='Y')&&(cho[i]=='Y'));
                    dp[i][j] = dp[i][j] || (dp[i-1][j]&&(chi[j]=='Y')&&(cho[i-1]=='Y')&&(cho[i]=='Y'));
                    if(j<n-1)
                    dp[i][j] = dp[i][j] || (dp[i][j+1]&&(chi[j]=='Y')&&(cho[j+1]=='Y')&&(cho[i]=='Y'));
                    if(i<n-1)
                    dp[i][j] = dp[i][j] || (dp[i+1][j]&&(chi[j]=='Y')&&(cho[i+1]=='Y')&&(cho[i]=='Y'));
                }
                
            }
            for(int i=n-2;i>0;i--)
            {
                
                for(int j=n-2;j>0;j--)
                {
                    //if(j>0)
                    if(j>0)
                    dp[i][j] = dp[i][j] || (dp[i][j-1]&&(chi[j]=='Y')&&(cho[j-1]=='Y')&&(cho[i]=='Y'));
                    if(i>0)
                    dp[i][j] = dp[i][j] || (dp[i-1][j]&&(chi[j]=='Y')&&(cho[i-1]=='Y')&&(cho[i]=='Y'));
                    if(j<n-1)
                    dp[i][j] = dp[i][j] || (dp[i][j+1]&&(chi[j]=='Y')&&(cho[j+1]=='Y')&&(cho[i]=='Y'));
                    if(i<n-1)
                    dp[i][j] = dp[i][j] || (dp[i+1][j]&&(chi[j]=='Y')&&(cho[i+1]=='Y')&&(cho[i]=='Y'));
                }
                
            }
            System.out.println("Case #"+(t1-t)+":");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                if(dp[i][j]) System.out.print('Y');
                else System.out.print('N');
                System.out.println();
            }
        }
        sc.close();
    }
}