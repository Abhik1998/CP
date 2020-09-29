import java.util.*;
public class a35{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            long max=a[n-1],s=a[n-1];
            for(int i=n-2;i>=0;i--)
            {
                s=(long) a[i]+ s;
                max=Math.max(max,s);
            }
            System.out.println(max);
        }
    }
}