import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner; 

import java.util.StringTokenizer;

  

public class dp11
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
    
    class Interval{
        
        int start;
        int end;
        int profit;
        
        Interval( int start , int end , int profit ){
            
            this.start = start;
            this.end = end;
            this.profit = profit;
            
        }
        
    }
    
    public long jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int maxProfit = Integer.MIN_VALUE;
        
        int len = startTime.length;
        
        List<Interval> list = new ArrayList<>();
        
        for( int i = 0 ; i < startTime.length ; i++ ){
            
            list.add( new Interval( startTime[i] , endTime[i] , profit[i] ) );
            
        }
        
        Collections.sort( list, ( i1 , i2 ) -> i1.start - i2.start );
        
        for( int i = 0 ; i < startTime.length ; i++ ){
            
            Interval interval = list.get( i );
            startTime[i] =  interval.start;
            endTime[i] = interval.end;
            profit[i] = interval.profit;
            
        }
        
        long[] dp = new long[ len ];
        dp[ len - 1 ] = profit[ len - 1 ];
        
        for( int i = len - 2 ; i >= 0 ; i-- ){
            
            int index = binarySearch( startTime , endTime[i] , i );
            long prof = ( index != -1 ) ? dp[ index ] : 0;
            
            dp[i] = Math.max( dp[ i + 1 ] , (long)profit[ i ] + prof );
            
        }
        
        return dp[0];
        
    }
    
    public int binarySearch( int[] startTime , int value , int beg ){
        
        int end = startTime.length - 1;
        
        int ans = -1;
        
        while( beg <= end ){
            
            int mid = beg + ( end - beg )/2;
            
            if( startTime[mid] > value ){ 
            
                ans = mid;
                end = mid - 1;
            
            }
            
            else{ beg = mid + 1; }
            
            
        }
        
        return ans;
        
    }
    public static void main(String args[])throws IOException {
        Reader sc=new Reader();
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            c[i]=sc.nextInt();
        }
        
        
        dp11 st=new dp11();
        
        System.out.println(st.jobScheduling(a, b, c));
    }
    
    
}