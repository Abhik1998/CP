import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader; 

import java.util.Scanner;
import java.util.HashSet; 

import java.util.StringTokenizer; 

  

public class a4
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
        while(t-->0)
        {
            int n=sc.nextInt(),k=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[101];
            HashSet<Integer> h=new HashSet<>();
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                h.add(a[i]);
                b[a[i]]+=1;
            }
            if(b[0]>0&&b[1]>0&&k==1)
            {
                System.out.println(-1);
                continue;
            }
            if(h.size()<=k)
            {
                System.out.println(1);
                continue;
            }
            for(int m=1;m<=100;m++)
            {
                if(h.size()<k*m)
                {
                    System.out.println(m);
                    break;
                }
            }
            
            
        }
        
    }
    
    
}