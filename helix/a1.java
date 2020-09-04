import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        int m=Integer.MAX_VALUE,max=0;
        for(int i=0;i<n;i++)
        {
            m = Math.min(m,a[i]);
            max= Math.max(max,a[i]-m);
        }
        System.out.println(max);
    }
}