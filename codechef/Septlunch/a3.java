import java.util.*;
import java.io.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int in[]=new int[n];
            int cnt=0;
            for(int i=0;i<n-1;i++)
            {
                int u=sc.nextInt();
                int v=sc.nextInt();
                in[v-1]+=1;
            }
            for(int i=0;i<n;i++)
            if(in[i]==0)
            cnt+=1;
            System.out.println(cnt-1);
        }
        sc.close();
    }
}