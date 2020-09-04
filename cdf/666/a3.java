import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        if(n==1){
            System.out.println(1+" "+1);
            System.out.println(-a[0]);
            System.out.println(1+" "+1);
            System.out.println(0);
            System.out.println(1+" "+1);
            System.out.println(0);
            return;

        }

        
        System.out.println(1+" "+n);
        for(int i=0;i<n;i++)
        System.out.print(((long)(-a[i]) * n)+" ");

        System.out.println();
        System.out.println(1+" "+(n-1));

        for(int i=0;i<n-1;i++)
        System.out.print(((long)(a[i]) * (n-1))+" ");

        System.out.println();
        System.out.println(2+" "+n);

        for(int i=1;i<n-1;i++)
        System.out.print(0+" ");

        System.out.println((long)a[n-1] * (n-1));
        return;
    }
        
 

}