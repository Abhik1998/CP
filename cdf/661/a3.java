import java.util.*;
public class a3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int w[]=new int[n];
            for(int i=0;i<n;i++)
            w[i]=sc.nextInt();
            int max=0;
            for(int s=2;s<=2*n;s++)
            {
                boolean vis[]=new boolean[n];
                int cnt=0;
                for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                if(i!=j&&!vis[i]&&!vis[j]&&w[i]+w[j]==s)
                {
                    cnt+=1;
                    vis[i]=true;
                    vis[j]=true;
                    break;
                }
                max = Math.max(max,cnt);

            }
            System.out.println(max);

        }
        sc.close();
    }
}