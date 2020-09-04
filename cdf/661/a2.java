import java.util.*;
public class a2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            for(int i=0;i<n;i++)
            b[i]=sc.nextInt();
            int mina=Integer.MAX_VALUE, minb=Integer.MAX_VALUE;
            long cnt=0;
            for(int i=0;i<n;i++)
            {
                mina=Math.min(a[i],mina);
                minb=Math.min(b[i],minb);
                
            }
            for(int i=0;i<n;i++){
                cnt = (long)cnt  +  Math.max(a[i]-mina,b[i]-minb);
            }
            System.out.println(cnt);

        }
        sc.close();
    }
}