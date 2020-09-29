import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++)
            a[i][0]=sc.nextInt();
            for(int i=0;i<n;i++)
            a[i][1]=sc.nextInt();
            
            TreeSet<Integer> tr=new TreeSet<>();
            for(int i=0;i<n;i++)
            if(a[i][1]==0)
            tr.add(-a[i][0]);
            int dp[]=new int[n];
            for(int i=0;i<n;i++)
            {
                if(a[i][1]==1)
                dp[i]=(i>0?dp[i-1]:0)+a[i][0];
                
            }
            for(int i=n-1;i>=0;i--)
            {
                if(a[i][1]==0)
                {
                    Integer in=tr.floor(i>0?dp[i-1]:0);
                    if(in!=null)
                    tr.remove(in);
                    if(in==null)
                    a[i][0]=-tr.pollLast();
                    else
                    a[i][0]=-in;
                }

            }
            for(int i=0;i<n;i++)
            {
                
                System.out.print(a[i][0]+" ");

            }
            System.out.println();
        }
    }
}