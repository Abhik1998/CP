import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            //int fl=0;
            // for(int i=2;i<n;i++)
            // {
            //     if((a[i-1]+a[i-2])<a[i])
            //     {
            //         System.out.println((i-2)+" "+(i-1)+" "+i);
            //         fl=1;
            //         break;
            //     }
            // }

            if(a[n-1]>=(a[0]+a[1]))
            System.out.println(1+" "+2+" "+n);
            else
            System.out.println(-1);
        }
        sc.close();

    }
}