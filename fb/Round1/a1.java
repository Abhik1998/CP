import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int mod = 1000000007;
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int w=sc.nextInt();
            int l[]=new int[n];
            int h[]=new int[n];
            for(int i=0;i<k;i++)
            l[i]=sc.nextInt();
            int a1=sc.nextInt(),b1=sc.nextInt(),c1=sc.nextInt(),d1=sc.nextInt();
            for(int i=k;i<n;i++)
            l[i] = (a1*l[i-2] + b1*l[i-1] + c1)%d1;

            for(int i=0;i<k;i++)
            h[i]=sc.nextInt();
            int a2=sc.nextInt(),b2=sc.nextInt(),c2=sc.nextInt(),d2=sc.nextInt();
            for(int i=k;i<n;i++)
            h[i] = (a2*h[i-2] + b2*h[i-1] + c2)%d2;

            int p[]=new int[n];
            int ch[]=new int[n];
            ch[0]=h[0];
            p[0]= 2*(w+h[0]);
            for(int i=1;i<n;i++){
                if(l[i-1]+w<l[i]){
                    ch[i]=h[i];
                    p[i]=p[i-1] + 2*(w+h[i]);
                }
                else{
                    ch[i] = ch[i-1]+Math.abs(h[i]-h[i-1]);
                    p[i] = 2*(l[i]-l[0]+w) + ch[i]+h[i];
                    
                }
                
            }
            
            long pd =1;
            for(int i=0;i<n;i++)
            {
                pd = (pd%mod * p[i]%mod)%mod;
                
            }
            System.out.println(pd);
        }
    }
    
}