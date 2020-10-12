import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner; 

import java.util.StringTokenizer; 

  

public class con2
{ 
   static class Edge{
        int u,v,w;
        Edge(int a,int b,int c){
            this.u=a;
            this.v=b;
            this.w=c;
        }
    }

    static class Reader 

    { 

        final private int BUFFER_SIZE = 1 << 16; 

        private DataInputStream din; 

        private byte[] buffer; 

        private int bufferPointer, bytesRead; 

  

        public Reader() 

        { 

            din = new DataInputStream(System.in); 

            buffer = new byte[BUFFER_SIZE]; 

            bufferPointer = bytesRead = 0; 

        } 

  

        public Reader(String file_name) throws IOException 

        { 

            din = new DataInputStream(new FileInputStream(file_name)); 

            buffer = new byte[BUFFER_SIZE]; 

            bufferPointer = bytesRead = 0; 

        } 

  

        public String readLine() throws IOException 

        { 

            byte[] buf = new byte[64]; // line length 

            int cnt = 0, c; 

            while ((c = read()) != -1) 

            { 

                if (c == '\n') 

                    break; 

                buf[cnt++] = (byte) c; 

            } 

            return new String(buf, 0, cnt); 

        } 

  

        public int nextInt() throws IOException 

        { 

            int ret = 0; 

            byte c = read(); 

            while (c <= ' ') 

                c = read(); 

            boolean neg = (c == '-'); 

            if (neg) 

                c = read(); 

            do

            { 

                ret = ret * 10 + c - '0'; 

            }  while ((c = read()) >= '0' && c <= '9'); 

  

            if (neg) 

                return -ret; 

            return ret; 

        } 

  

        public long nextLong() throws IOException 

        { 

            long ret = 0; 

            byte c = read(); 

            while (c <= ' ') 

                c = read(); 

            boolean neg = (c == '-'); 

            if (neg) 

                c = read(); 

            do { 

                ret = ret * 10 + c - '0'; 

            } 

            while ((c = read()) >= '0' && c <= '9'); 

            if (neg) 

                return -ret; 

            return ret; 

        } 

  

        public double nextDouble() throws IOException 

        { 

            double ret = 0, div = 1; 

            byte c = read(); 

            while (c <= ' ') 

                c = read(); 

            boolean neg = (c == '-'); 

            if (neg) 

                c = read(); 

  

            do { 

                ret = ret * 10 + c - '0'; 

            } 

            while ((c = read()) >= '0' && c <= '9'); 

  

            if (c == '.') 

            { 

                while ((c = read()) >= '0' && c <= '9') 

                { 

                    ret += (c - '0') / (div *= 10); 

                } 

            } 

  

            if (neg) 

                return -ret; 

            return ret; 

        } 

  

        private void fillBuffer() throws IOException 

        { 

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 

            if (bytesRead == -1) 

                buffer[0] = -1; 

        } 

  

        private byte read() throws IOException 

        { 

            if (bufferPointer == bytesRead) 

                fillBuffer(); 

            return buffer[bufferPointer++]; 

        } 

  

        public void close() throws IOException 

        { 

            if (din == null) 

                return; 

            din.close(); 

        } 

    } 
    static int dist;
    public static void main(String args[])throws IOException {
        Reader sc=new Reader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        String s=sc.readLine();
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
        //HashMap<Integer,Integer> map=new HashMap<>();
        //Deque<Integer> dq=new LinkedList<>();
        int a[]=new int[m];
        ArrayList<Integer> g[]=new ArrayList[m];
        for(int i=0;i<m;i++)
        g[i]=new ArrayList<>();
        while(!pq.isEmpty()){
            Edge e=pq.poll();
            if(a[e.v]>1||a[e.u]>1)
            continue;
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