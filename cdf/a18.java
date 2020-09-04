import java.io.*;
import java.util.*;
public class a18{
    public static void main(String[] args)throws Exception {
        //Scanner sc=new Scanner(System.in);
        File file = new File("/home/abhik/Downloads/timber_validation_input.txt"); 
        //File file = new File("/home/abhik/cp/cdf/test1.txt"); 
        BufferedReader br =new BufferedReader(new FileReader(file));

        int t = Integer.parseInt(br.readLine());
        int t1 = t;
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int p[]=new int[n];
            int h[]=new int[n];
            long dp[][]=new long[n][2];
            int a[][]=new int[n][2];
            //boolean sp[]=new boolean[n];
            for(int i=0;i<n;i++){
                String str[]=br.readLine().split(" ");
                p[i]=Integer.parseInt(str[0]);
                h[i]=Integer.parseInt(str[1]);
                a[i][0]=p[i];
                a[i][1]=h[i];
            }
            Arrays.sort(a,(x,y)->x[0]-y[0]);
            for(int i=0;i<n;i++){
                p[i] = a[i][0];
                h[i] = a[i][1];
            }
            dp[0][0]=h[0];
            dp[0][1]=h[0];
            long max=0;
            //HashMap<Integer,Integer> h1=new HashMap<>();
            HashMap<Integer,Integer> h2=new HashMap<>();
            HashMap<Integer,Integer> h3=new HashMap<>();
            //h1.put(p[0]-h[0],0);
            h2.put(p[0]+h[0],0);
            h3.put(p[0],0);
            for(int i=1;i<n;i++){
                //dp[i] = dp[i-1] + (h[i-1]==(p[i]-p[i-1])?h[i-1]:0) 
                // if(h[i]==(p[i]-p[i-1]))
                // dp[i][0] = dp[i-1][0] + h[i];
                // if(h[i]+h[i-1]==(p[i]-p[i-1]))
                // dp[i][0] = dp[i-1][1] + h[i] + h[i-1];
                // if(h[i-1]==(p[i]-p[i-1]))
                // dp[i][1] = dp[i-1][1] + h[i-1];
                // max = Math.max(max,dp[i][0]);
                // max = Math.max(max,dp[i][1]);
                dp[i][1] = h[i];
                dp[i][0]=h[i];
                if(h2.containsKey(p[i]-h[i])||h2.containsKey(p[i])||(h3.containsKey(p[i]-h[i])))
                {
                    long tempy=0,tempz=0,temx=0;
                    if(h2.containsKey(p[i]-h[i]))
                    temx = (long)dp[i][0] +  dp[h2.get(p[i]-h[i])][1];
                    if(h2.containsKey(p[i]))
                    tempy = dp[h2.get(p[i])][1];
                    if(h3.containsKey(p[i]-h[i]))
                    tempz = (long)dp[i][0] + dp[h3.get(p[i]-h[i])][0];
                    dp[i][0]= Math.max(Math.max(temx,tempz),dp[i][0]);
                    dp[i][1]=(long)dp[i][1] + tempy;
                    max = Math.max(Math.max(dp[i][0],max),dp[i][1]);
                    //if(!h2.containsKey(p[i]+h[i]))
                //     h2.put(p[i]+h[i],i);
                //     //System.out.println(temx+" "+tempz);
                
                // h3.put(p[i],i);
                    
                }
                if(!h2.containsKey(p[i]+h[i]))
                    h2.put(p[i]+h[i],i);
                
                h3.put(p[i],i);
                //System.out.println(dp[i][0]+" "+dp[i][1]+" "+max);
                

            }
            if(max==0)
            max = getheight(h,n);
            System.out.println("Case #"+(t1-t)+": "+max);
        }

    }
    public static int getheight(int h[],int n){
        int max=0;
        for(int i=0;i<n;i++)
        max=Math.max(h[i],max);
        return max;
    }
}