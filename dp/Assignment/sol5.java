import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner; 

import java.util.StringTokenizer; 
class Pair{
    int f,w;
    Pair(int a,int b){
        this.f=a;
        this.w=b;
    }
}
  

public class sol2 
{ 

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
    public static void main(String args[])throws IOException {
        Reader sc=new Reader();
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            ArrayList<Pair> g1[]=new ArrayList[n];
            int m=sc.nextInt();
            for(int i=0;i<n;i++)
                g1[i]=new ArrayList<Pair>();
            while(m-->0){
                int u=sc.nextInt(),v=sc.nextInt(),w=sc.nextInt(); 
                g1[u-1].add(new Pair(v-1,w));
                g1[v-1].add(new Pair(u-1,w));
            }
            int pr[]=new int[n];
            for(int i=0;i<n;i++)
                pr[i]=sc.nextInt();
            int st=sc.nextInt(),dest=sc.nextInt();
            int dp[]=new int[n][n];
            
            
        }
    }
    
    
}