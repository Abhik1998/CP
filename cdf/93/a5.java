import java.util.*;
public class a5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=6;
            int a[][]=new int[n][2];
            int d[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i][0] = sc.nextInt();
                d[i]=a[i][0];
            }
            int b=sc.nextInt();
            int c =Arrays.binarySearch(d, b);
            if(c<0)
            c = -c-1;
            System.out.println(bs(a,b,n) +" "+c);
        }
        sc.close();

    }
    public static int bs(int a[][],int b,int end){
        int l=0;
        int r=end-1;
        if(a[l][0]>=b)
        return l;
        while(l<r){
            int m = (l + r)/2;
            if(a[m][0]==b)
            return m;
            if(a[m][0]>b)
            r = m-1;
            if(a[m][0]<b)
            l = m+1;
        }
        return r+1;
    }
}