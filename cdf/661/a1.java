import java.util.*;
public class a1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            Arrays.sort(a);
            int fl=0;
            for(int i=1;i<n;i++)
            if(a[i]-a[i-1]>1)
            {
                System.out.println("NO");
                fl=1;
                break;
            }
            if(fl==0)
            System.out.println("YES");

        }
        sc.close();
    }
}