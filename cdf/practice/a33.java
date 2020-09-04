import java.util.*;

public class a33{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int min =Integer.MAX_VALUE,c=0,d=0;
        
        // int l[]=new int[n];
        // int r[]=new int[n];
        long sum =0;
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            sum = (long)sum + Math.abs(a[i]);
            
            min=Math.min(min,Math.abs(a[i]));
            if(a[i]<=0)
            c+=1;
            

        }
        if(n==1)
        {
            System.out.println(a[0]);
            return;
        }
        
        long max=0;
        if(c!=0&&(n-c)!=0)
        max = sum;
        else
        max= (long)sum - ((long)2*min);
        
        System.out.println(max);

        
        
    }
}