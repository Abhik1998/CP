import java.util.*;

import sun.text.resources.CollationData;
public class a2{
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
            
            int sump=0,sumn=0;
            TreeSet<Integer> lp=new TreeSet<>();
            TreeSet<Integer> ln=new TreeSet<>();
            
            int dp[]=new int[n];
            for(int i=0;i<n;i++)
            {
                if(a[i][1]==1)
                dp[i]=(i>0?dp[i-1]:0)+a[i][0];
                else
                {
                    if(a[i][0]<0)
                    {
                        ln.add(-a[i][0]);
                        sumn+=a[i][0];
                    }
                    else
                    {
                        lp.add(a[i][0]);
                        sump+=a[i][0];
                    }
                }
                
            }
            
            for(int i=n-1;i>=0;i--)
            {
                if(a[i][1]==0)
                {
                   Integer in=ln.floor(dp[i-1]+lp.last());
                   if(in==null)
                   a[i][0]=
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