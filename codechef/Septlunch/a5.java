import java.util.*;
import java.io.*;
public class a5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            boolean fl=false;
            int sum=0,a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum+=a[i];
            }
            if(sum>=0) 
            fl=true;
            if(!fl)
            System.out.println("NO");
            else
            System.out.println("YES");
        }
        sc.close();
    }
}