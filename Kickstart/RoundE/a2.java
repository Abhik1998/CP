import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=t;
        while(t-->0){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a+b-c>n||(a==1&&b==1&&c==1&&n!=1))
              {
                  System.out.println("Case #"+(k-t)+": IMPOSSIBLE");
                  continue;
              }
            //Deque<Integer> dq=new LinkedList<>();
            a-=c;
            b-=c;
            // while(c-->0)
            // dq.addFirst(n);
            int dp[]=new int[n];

            for(int i=0;i<a;i++)
            dp[i]=(i+1);
            int kl=a;
            while(kl<a+c)
            dp[kl++]=n;
            //int m=n-a-c;
            if(b!=0)
            for(int i=a+c;i<n-b;i++)
            dp[i]=1;
            else
            {
                

                for(int i=a+c-1;i<n-1;i++)
                dp[i]=n-1;
                dp[n-1]=n;
            }
            if(a!=0&&c==1)
            {
                dp[0]=2;
                dp[n-1]=n;
                for(int i=1;i<n-1;i++)
                dp[i]=1;
            }
            kl=n-1;
            for(int i=n-b;i<n;i++)
              dp[i]=n-1;
              System.out.println("Case #"+(k-t)+": ");
            for(int i=0;i<n;i++)
            System.out.print(dp[i]+" ");
            System.out.println();



            
        }
        sc.close();
    }
}