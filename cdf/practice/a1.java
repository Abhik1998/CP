import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        Arrays.sort(a);
        HashSet<Integer> min=new HashSet<>();
        HashSet<Integer> max=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            if(!max.contains(a[i]))
            max.add(a[i]);
            else
            if(!max.contains(a[i]-1))
            max.add(a[i]-1);
            else
            if(!max.contains(a[i]+1))
            max.add(a[i]+1);

        }
        
        
        int dp[]=new int[n];
        dp[0]=1;
        
        for(int i=1;i<n;i++)
        {
            if((a[i]==a[i-1]))
            dp[i]=dp[i-1];
            else
            if(a[i]-a[i-1]==1)
            {
                dp[i]=dp[i-1];
                a[i]-=1;
            }
            else
            if(a[i]-a[i-1]==2)
            {
                if(i==1||(i>1&&a[i-2]!=a[i-1]))
                {
                    dp[i]=dp[i-1];
                    a[i]-=1;
                    a[i-1]+=1;
                }
                else
                dp[i]=dp[i-1]+1;
            }
            else
            dp[i]=dp[i-1]+1;
           System.out.println(dp[i]+" "+a[i]);

        }
        System.out.println(dp[n-1] +" "+max.size());
    }
}