import java.util.*;
public class a4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //int t=sc.nextInt();
       // while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[2*n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            int k=0;
            for(int i=0;i<n;i+=2)
            b[k++]=a[i];
            for(int i=1;i<n;i+=2)
                b[k++]=a[i];
            for(int i=0;i<n;i+=2)
                b[k++]=a[i];
            for(int i=1;i<n;i+=2)
                b[k++]=a[i];
            long sum = 0, max=0;
            for(int i=0;i<(n+1)/2;i++)
            sum=(long)sum + b[i];
            for(int i=(n+1)/2;i<2*n;i++)
            {
                sum= (long)sum + b[i]-b[i-(n+1)/2];
                max= Math.max(sum,max);
            }
            System.out.println(max);

        //}
        sc.close();
    }
}