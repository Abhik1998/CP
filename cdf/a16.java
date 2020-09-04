import java.util.*;
public class a16{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int t1=t;
        while(t-->0){
            int n=sc.nextInt();
            char ch1[]=sc.next().toCharArray();
            char ch2[]=sc.next().toCharArray();
            boolean dp[][]=new boolean[n][n];
            dp[0][0]=true;
            for(int i=0;i<n;i++)
            dp[i][i]=true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!(ch1[j]=='Y'&&ch2[i]=='Y'))
                    continue;
                    dp[i][j]=true;
                    if(i<j){
                        for(int k=i+1;k<j;k++)
                        dp[i][j]=dp[i][j] && ch1[k]=='Y' && ch2[k]=='Y';
                    }
                    if(i>j){
                        for(int k=j+1;k<i;k++)
                        dp[i][j]=dp[i][j] && ch1[k]=='Y' && ch2[k]=='Y';
                    }

                    
                }
            }
            System.out.println("Case #"+(t1-t)+": ");
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                if(dp[i][j]) System.out.print('Y'); else System.out.print('N');
                System.out.println();
            }
        }
        sc.close();
    }
}