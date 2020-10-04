import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader; 

import java.util.Scanner; 

import java.util.StringTokenizer; 

  

public class segmenttree
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
    int st[];
    segmenttree(int arr[],int n){
        int x=(int)Math.ceil((double)Math.log(n)/Math.log(2));
        int ms=2*(int)Math.pow(2,x)-1;
        st=new int[ms];
        buildUtil(arr,0,n-1,0,0);
    }
    
    public int buildUtil(int arr[],int ss,int se,int si,int l){
        if(ss==se){
            st[si]=arr[ss];
            return arr[ss];
        }
        int mid=ss+(se-ss)/2;
        if((l&1)==1)
        st[si]=buildUtil(arr,ss,mid-1,2*si + 1,l+1)^build(arr,mid+1,se,2*si+2,l+1);
        else
        st[si]=buildUtil(arr,ss,mid-1,2*si + 1,l+1)||build(arr,mid+1,se,2*si+2,l+1);
    }

    public static void main(String args[])throws IOException {
        Reader sc=new Reader();
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        
        
    }
    
    
}