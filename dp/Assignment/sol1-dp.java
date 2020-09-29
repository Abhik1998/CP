//Author Abhik Chakraborty
import java.util.*;
class sol1dp
{
    static ArrayList<String> lt,temp;
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=sc.nextInt();
        System.out.println("Enter the number of edges");
        int m=sc.nextInt();
        ArrayList<Integer> g[]=new ArrayList[n];
        
	    for(int i=0;i<n;i++)
        g[i]=new ArrayList<Integer>();
        int in[]=new int[n];
        System.out.println("Enter the edges");
        for(int i=0;i<m;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            g[u].add(v);
            in[v]+=1;
        }
	    
        System.out.println("Paths are "+paths(g,n,in));
        sc.close();
	}
	
	public static ArrayList<String> paths(ArrayList<Integer> g[],int n,int in[]){
        lt=new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map=new HashMap<>();
        boolean vis[]=new boolean[n];
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        a[i]=i;
        sort(a,g,n,in);
	    for(int i=0;i<n;i++){
            temp=new ArrayList<>();
                helperUtil(g,n,a[i],new String(),map,vis);
                map.put(a[i],temp);
                vis[a[i]]=true;
        }
        System.out.println("Path count "+lt.size());
        // System.out.println(map);
	    return lt;
	}
	public static void helperUtil(ArrayList<Integer> g[],int n,int u,String s,HashMap<Integer, ArrayList<String>> map,boolean vis[]){
	    if(s.indexOf(u)>=0)
	    return;
        s+=" "+u;
        if(s.length()>2)
        lt.add(s.trim());
        temp.add(s.trim());
	    for(int i=0;i<g[u].size();i++)
	    {
            int in = g[u].get(i);
            if(!vis[in])
            helperUtil(g,n,in,s,map,vis);
            else
            addmap(s,map.get(in));
	    }
    }
    public static void addmap(String s,ArrayList<String> l){
        // System.out.println("abk");
        for(int i=0;i<l.size();i++)
        {
            lt.add((s+" "+l.get(i)).trim());
            temp.add((s+" "+l.get(i)).trim());

        }
    }
    public static void sort(int a[],ArrayList<Integer> g[],int n,int in[]){
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=i;
            dp[i][1]=g[i].size();
        }
        Arrays.sort(dp,(x,y) -> x[1]-y[1]);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
                if(dp[i][1]==dp[j][1]&&in[dp[i][0]]>in[dp[j][0]])
                {
                    int teu=dp[i][0];
                    dp[i][0]=dp[j][0];
                    dp[j][0]=teu;
                    teu=dp[i][1];
                    dp[i][1]=dp[j][1];
                    dp[j][1]=teu;
                }
        }
        for(int i=0;i<n;i++)
        {
            a[i]=dp[i][0];
        }



    }
}