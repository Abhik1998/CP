import java.util.*;
public class a1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int s=sc.nextInt();
        int p=sc.nextInt();
        double dp[][][]=new double[r+1][s+1][p+1];
        dp[r][s][p]=1;
        dp[r][s][p-1] = (double)s*p / (s*p+p*r+r*s);
        dp[r][s-1][p] = (double)s*r / (s*p+p*r+r*s);
        dp[r-1][s][p] = (double)r*p / (s*p+p*r+r*s);
        //System.out.println(dp[r][s][p-1]+" "+dp[r][s-1][p]+" "+dp[r-1][s][p]);
        for(int i=r-1;i>=0;i--){
            dp[i][s][p] = (double)dp[i+1][s][p] * ((double)(i+1)*p/((i+1)*s + s*p + p*(i+1)));
            for(int j=s-1;j>=0;j--){
                dp[i][j][p] = (double)dp[i][j+1][p] * ((double)(j+1)*p/(i*(j+1) + (j+1)*p + p*i));
                for(int k=p-1;k>=0;k--){
                    dp[i][j][k] =(double)dp[i][j][k+1] * ((double)j*(k+1)/(i*j + j*(k+1) + (k+1)*i));
                    System.out.println(dp[i][j][k]+ " "+i+" "+j+" "+k);

                }
            }
        }
        double sum=0;
        for(int i=1;i<=r;i++)
        sum = (double) sum + dp[i][0][0];
        double s2 =0;
        for(int i=1;i<=s;i++)
        s2 = (double) s2 + dp[0][i][0];
        double s3=0;
        for(int i=1;i<=p;i++)
        s3 = (double) s3 + dp[0][0][i];
        System.out.println(sum + " "+s2+" "+s3);


    
        sc.close();
    }
    }