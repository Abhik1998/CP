
import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader; 

import java.util.Scanner; 


import java.util.StringTokenizer; 

  

public class a2
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
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            int b[]=new int[n];
            dnc(a,n,b);
        }
    }
    public static void dnc(int a[],int n,int b[]){
        int min = a[n/2];
        int c[][]=new int[n+1][3];
        //if((n&1)!=0)
        for(int i=n/2;i<n;i++)
        {
            min=Math.min(min,a[n-i-1]);
            min=Math.min(min,a[i]);
            b[n-i-1]=-1;
            b[i]=min;
            
        }
        
        //int newk=n/2,newmin=-1;
        for(int i=0;i<=n;i++)
            c[i][1]=-1;

        for(int i=0;i<n;i++)
        {
            c[a[i]][1]=Math.max(c[a[i]][1],i-c[a[i]][0]);
            c[a[i]][0]=i;
            c[a[i]][2]+=1;
        }
        for(int i=0;i<n;i++){
            c[a[i]][1]=Math.max(c[a[i]][1],n-c[a[i]][0]);
        }
        int maxk=n/2+1;
        for(int i=1;i<=n;i++)
        {
            if(c[i][1]>=maxk)
            continue;
            if(c[i][1]!=-1&&c[i][2]>1){
                maxk=c[i][1];
                for(int k=c[i][1];k<=n/2;k++)
                {
                    if(b[k-1]!=-1)
                    break;
                    b[k-1]=i;
                }
            }
            
        }
        
        for(int i=0;i<n;i++)
            System.out.print(b[i]+" ");
        System.out.println();
              
    }
}