import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            Arrays.sort(a);
            long p=1,max=Long.MIN_VALUE;
            for(int i=n-1;i>=n-5;i--)
            {
                p=(long)p*a[i];
            }
            max=Math.max(max,p);

            if(a[0]>=0||a[n-1]<=0)
            System.out.println(max);
            else
            {
                if(a[3]<=0&&a[n-1]>=0)
                {
                    p=(long)a[0]*a[1]*a[2]*a[3]*a[n-1];
                    max=Math.max(p,max);
                }
                if(a[1]<=0&&a[n-3]>=0)
                {
                    p=(long)a[0]*a[1]*a[n-1]*a[n-2]*a[n-3];
                    max=Math.max(p,max);
                }
                System.out.println(max);
            }
            
            



        }
        sc.close();
    }
}