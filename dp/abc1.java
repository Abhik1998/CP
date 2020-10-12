import java.util.*;
public class abc1{
    static class Edge{
        int u,v,w;
        Edge(int a,int b,int c){
            this.u=a;
            this.v=b;
            this.w=c;
        }
    }
    static int dist;
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String s=sc.next();
        //ArrayList<Integer> g[]=new ArrayList[m];
        //int e[][]=new int[m][3];
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b) -> Integer.compare(b.w,a.w));
        int w[][]=new int[26][26]; 
        for(int i=1;i<n;i++){
            w[s.charAt(i)-'a'][s.charAt(i-1)-'a']+=1;
            w[s.charAt(i-1)-'a'][s.charAt(i)-'a']+=1;
        }
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++)
            {
                if(w[i][j]>0&&i!=j)
                {
                    pq.add(new Edge(i,j,w[i][j]));
                }
            }
        int parent[]=new int[m];
        for(int i=0;i<m;i++)
        parent[i]=i;
        int sum=0,k=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        //Deque<Integer> dq=new LinkedList<>();
        int a[]=new int[m];
        ArrayList<Integer> g[]=new ArrayList[m];
        for(int i=0;i<m;i++)
        g[i]=new ArrayList<>();
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            if(a[e.v]>1||a[e.u]>1)
            {
                map.put(e.v,e.u);map.put(e.u,e.v);
                continue;
            }
            int x = find(e.u,parent);
            int y=find(e.v,parent);
            if(x!=y){
                a[e.u]+=1;
                a[e.v]+=1;
                g[e.v].add(e.u);
                g[e.u].add(e.v);
                parent[x]=y;
            }
        }
        for(int i=0;i<m;i++)
        {
            if(g[i].size()==0)
            {
                for(int j=0;j<m;j++)
                if(g[j].size()==1)
                {
                    g[j].add(i);
                    g[i].add(j);
                    break;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            dist=0;
            dis(g,s.charAt(i)-'a',s.charAt(i-1)-'a',0,new boolean[m]);
            sum+=dist;
        }
        
        System.out.println(sum);
    }
    public static int find(int x,int parent[]){
        if(parent[x]==x)
        return x;
        return find(parent[x],parent);
    }
    public static void dis(ArrayList<Integer> g[],int u,int v,int cnt,boolean vis[]){
        if(u==v)
        {
            dist=cnt;
            return;
        }
        vis[u]=true;
        for(int i=0;i<g[u].size();i++)
        {
            if(!vis[g[u].get(i)])
            dis(g,g[u].get(i),v,cnt+1,vis);
        }
    }
}