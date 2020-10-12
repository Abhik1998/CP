import java.io.DataInputStream; 

import java.io.FileInputStream; 

import java.io.IOException; 

import java.io.InputStreamReader; 

import java.util.Scanner; 

import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6; 

  

public class a6 
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
    static int lps[];

static int LPS(String s1) {
    if(s1.length()<=1)   return s1.length();
    String p = s1; 
    p= rev(p);
    String s = s1+"#"+ p;
    lps[0] = 0; int j = 0;
    for(int i=1;i<s.length();i++) {
        while(j!=0 && s.charAt(i)!=s.charAt(j))  
            j = lps[j-1];
            j+=(s.charAt(i)==s.charAt(j)?1:0);
            lps[i]=j;
    }

    return 2*s1.length()-lps[s.length()-1];
}

static int LPSrev(String s) {
    rev(s);
    return LPS(s);
}
    public static void main(String args[])throws IOException {
        Reader sc=new Reader();
        int t=sc.nextInt();
        while(t-->0){
            String str[]=sc.readLine().split(" ");
            String s=str[0];
            lps=new int[10000];
            String tl=str[1];String rs=rev(s),rtl=rev(tl);
            if(s.indexOf(tl)>=0||s.indexOf(rtl)>=0)
            {
                System.out .println(Math.min(LPS(s),LPSrev(s)));
                continue;
            }
            if(tl.indexOf(s)>=0||tl.indexOf(rs)>=0)
            {
                System.out .println(Math.min(LPS(tl),LPSrev(rtl)));
                continue;
            }
            
            
             String a=concatit(s,tl);
             String b=concatit(tl,s);
             String c=concatit(tl,rs);
             String d=concatit(rs,tl);
             String e=concatit(s,rtl);
             String f=concatit(rtl,s);
             String g=concatit(rtl,rs);
             String h=concatit(rs,rtl);
             //System.out.println(newtl+" "+news);
             System.out.println(Math.min(min(LPS(a),LPS(b),LPS(c),LPS(d),LPS(e),LPS(f),LPS(g),LPS(h)),min(LPSrev(a),LPSrev(b),LPSrev(c),LPSrev(d),LPSrev(e),LPSrev(f),LPSrev(g),LPSrev(h))));

        }
        
    }
    // public static int LPString(String s){
    //     int n=s.length();
    //     int l[][]=new int[n+1][n+1];
    //     for(int i=0;i<n;i++)
    //     l[i][i]=1;
    //     for(int sl=2;sl<=n;sl++)
    //         for(int i=0;i<n-sl+1;i++)
    //         {
    //             int j=i+sl-1;
    //             if(s.charAt(i)==s.charAt(j))
    //             {
    //                 if(sl==2)
    //                 l[i][j]=2;
    //                 else
    //                 l[i][j]=l[i+1][j-1]+2;
    //             }
    //             else
    //             l[i][j]=Math.max(l[i+1][j],l[i][j-1]);
    //         }
    //     return (2*n)-l[0][n-1];
    // }
    public static String concatit(String s1,String s2){
        String s = s1 +"#" + s2;
        lps[0] = 0; int j = 0;
        for(int i=1;i<s.length();i++) {
            while(j!=0 && s.charAt(i)!=s.charAt(j))  
            j = lps[j-1];
            j+=(s.charAt(i)==s.charAt(j)?2:0);
            lps[i]=j;
        }
    return s1 + s2.substring(lps[s.length()-1]);
    }
    public static String rev(String s){
        return (new StringBuilder(s).reverse()).toString();
    }
    public static int min(int a,int b,int c,int d,int e,int f,int g,int h){
        int min=Integer.MAX_VALUE;
        min=Math.min(min,a);
        min=Math.min(min,b);
        min=Math.min(min,c);
        min=Math.min(min,d);
        min=Math.min(min,e);
        min=Math.min(min,f);
        min=Math.min(min,g);
        min=Math.min(min,h);
        //System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h);
        return min;
    }
}