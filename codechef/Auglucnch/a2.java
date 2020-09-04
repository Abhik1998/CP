import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int r[]=new int[n];
            int c[][]=new int[n][m];
            int dp[][]=new int[n][2];
            for(int i=0;i<n;i++)
            r[i]=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                c[i][j]=sc.nextInt();
            }
            int rk[][]=new int[n][m];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    c[j][i] += r[j];
                    r[j] = c[j][i];
                    dp[j][0] = r[j];
                    dp[j][1] = j;
                }
                //int rtk[]=new int[n],rcnt=0;
                Arrays.sort(dp,(x,y)->x[0]-y[0]);
                // for(int j=1;j<n;j++)
                // rtk[j]=rtk[j-1] + dp[j][0]==dp[j-1][0]?0:1;
                print(dp);
                rk[dp[0][1]][i] = n-1;
                for(int j=1;j<n;j++)
                rk[dp[j][1]][i] = rk[dp[j-1][1]][i] - dp[j-1][0]==dp[j][0]?0:1;


            }
            //int rat[]=new int[n];
            int fl=0;
            for(int i=0;i<n;i++)
            {
                int max_rat=0;
                for(int j=0;j<m;j++){
                    max_rat = Math.max(max_rat,c[i][j]);
                }
                for(int j=0;j<m;j++)
                if((max_rat==c[i][j]&&rk[i][j]!=0)||(max_rat!=c[i][j]&&rk[i][j]==0))
                {
                    System.out.println(i+1);
                    fl=1;
                    break;
                    
                }
                if(fl==1)
                break;
            }
            print(rk);
            
            if(fl==1)
            continue;
            System.out.println(-1);
        }
    }
    public static void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++)
            System.out.print(a[i][j]+" ");
            System.out.println();
        }
    }
}