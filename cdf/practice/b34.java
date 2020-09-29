import java.util.*;
public class b34{
    static ArrayList<Integer> f=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int x=sc.nextInt(),k=n-1,maxa=0;
        int a[]=new int[n+1];
        ArrayList<Integer> g[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
        g[i]=new ArrayList<Integer>();
        while(k-->0){
            int u=sc.nextInt();
            int v=sc.nextInt();
            g[u].add(v);g[v].add(u);
        }
        for(int i=1;i<=n;i++)
            {
                a[i]=sc.nextInt();
                maxa=Math.max(maxa,a[i]);
            }
        
        f.add(1);
        int cnt[]=new int[1];
        cnt[0]=1;
        for(int i=1;i<=9;i++)
            {
                if(i*i<=x)
                recurUtil(i,x-i*i,cnt,maxa);
            }
        while(m-->0){
            int q=sc.nextInt(),in=sc.nextInt();
            if(q==1)
            {
                int y=sc.nextInt();
                
            }else
            {

            }
            
        }

        
        sc.close();
    }
    public static void recurUtil(int a,int x,int cnt[],int maxa){
        if(maxa<=cnt[0]-1)
        return;
        for(int i=0;i<=9;i++)
        {
            if(i*i<=x){
                a=a*10+i;
                f.add(a);
                cnt[0]+=1;
                recurUtil(a,x-(i*i),cnt,maxa);
            }
        }
    }
}