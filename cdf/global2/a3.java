import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char ch[]=sc.next().toCharArray();
            int n=ch.length,fl=0;

            char w[]=new char[n];

            int x=sc.nextInt();

            boolean vis[]=new boolean[n];
            //w[0] = ch[x];
            for(int i=0;i<x&&(i+x)<n;i++)
            {
                w[i]=ch[i+x];
                vis[i]=true;
            }
            for(int i=0;i<x && (i+x)<n;i++){
                w[i+x] = ch[i];
                vis[i+x] = true; 
            }
            for(int i=2*x;i<n;i++)
            {
                if(ch[i-x] != w[i-2*x])
                {
                    if(!vis[i-2*x])
                    {
                        w[i-2*x] = ch[i-x];
                        vis[i-2*x] = true;
                    }
                    else
                    {
                        w[i] = ch[i-x];
                        vis[i]=true;
                    }
                    
                }
            }
            for(int i=n-x;i<n&&(i-x)>=0;i++)
            {
                if(ch[i]!=w[i-x])
                {
                    if(!vis[i-x]){
                        w[i-x] = ch[i];
                        vis[i-x] = true;
                    }
                    else{
                        fl=1;
                        System.out.println(-1);
                        break;
                    }
                }
            }
            if(fl==1)
            continue;
            for(int i=0;i<n;i++)
            if(!vis[i])
            w[i]='0';


            for(int i=0;i<n;i++)
            System.out.print(w[i]);
            System.out.println();




        }
        sc.close();
    }
}