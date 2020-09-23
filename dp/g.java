import java.util.*;
class gr{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        ArrayList<Integer>[] g=(ArrayList<Integer>[])new ArrayList[n];
        for(int i=0;i<n;i++)
        g[i]=new ArrayList<Integer>();
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt(),v=sc.nextInt();
            g[u-1].add(v-1);
        }
        int dp[]=new int[n];
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            dfs(g,dp,vis,i,n);
        }
        int max=0;
        for(int i=0;i<n;i++)
        max=Math.max(max,dp[i]);
        System.out.println(max);
        sc.close();
    }
    public static void dfs(ArrayList<Integer> g[],int dp[],boolean vis[],int pos,int n){
        if(pos>=n)
        return;
        vis[pos]=true;
        for(int i=0;i<g[pos].size();i++)
        {
            int in=g[pos].get(i);
            
            if(!vis[in])
            dfs(g,dp,vis,in,n);
            dp[pos]=Math.max(dp[pos],dp[in]+1);
        }
    }
}