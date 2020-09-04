import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        long dp[]=new long[100001];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        dp[i]=(long)i+dp[(i+1)/2];
        while(t-->0){
            int d=sc.nextInt();
            int p=sc.nextInt();
            if(d<dp[p])
            System.out.println(1);
            else
            System.out.println(0);
        }

    }
}