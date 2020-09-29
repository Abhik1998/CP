import java.util.*;
import java.io.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        int k=t;
        while(t-->0){
            int n=sc.nextInt();
            int X=sc.nextInt();
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                int at=sc.nextInt();
                a[i][0]=i+1;
                a[i][1]=at/X;
            }
            Arrays.sort(a,(y,z) -> y[1]-z[1]);
            
            System.out.print("Case #"+(k-t)+": ");
            for(int i=0;i<n;i++)
            System.out.print(a[i][0]+" ");
            System.out.println();
        }
        sc.close();
    }
}