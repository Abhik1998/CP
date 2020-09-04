import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            long sum=0;
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            for(int i=1;i<n;i++)
            if(a[i]<a[i-1])
            sum=(long)sum + (a[i-1]-a[i]);
            System.out.println(sum);
        }
    }
}