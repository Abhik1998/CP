import java.io.*;
import java.util.*;

public class a19{
    public static void main(String[] args)throws Exception {
        //Scanner sc=new Scanner(System.in);
        File file = new File("/home/abhik/Downloads/run.txt"); 
  
    BufferedReader br = new BufferedReader(new FileReader(file)); 
        int t=Integer.parseInt(br.readLine());
        int t1=t;
        while(t-->0){
            String str[]=br.readLine().split(" ");
            //int m=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            // int n=Integer.parseInt(br.readLine());
            // int m=Integer.parseInt(br.readLine());
            long a[]=new long[n];
            long max = (long)Math.pow(10,15)+1;
            System.out.println(max);
            a[0]=Integer.parseInt(br.readLine());
            for(int i=1;i<n;i++){
                a[i]=(long)Integer.parseInt(br.readLine());
                if(a[i]==0)
                a[i]=max;
            }
            long dp[]=new long[n];
            //Arrays.fill(dp,1000000000000001);
            
            for(int i=0;i<n;i++)
            dp[i]=max;
            dp[0]=0;
            for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<i+m+1 && j<n;j++)
                //if(a[j]!=0)
                dp[j] = Math.min(dp[j],(long)dp[i] + a[j]);
                System.out.print(dp[i]+" ");
            }
            System.out.println();
            if(dp[n-1]>=max||dp[n-1]<0)
            System.out.println("Case #"+(t1-t)+": "+(-1));
            else
            System.out.println("Case #"+(t1-t)+": "+(dp[n-1]-a[n-1]));
        }
    }
}