import java.util.*;
public class a4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            char ch[]=sc.next().toCharArray();
            int max=100000,c=1;
            // for(int i=1;i<n;i++)
            // if(ch[i]==ch[i-1])
            // c+=1;
            // else{
            //     max=Math.max(max,c);
            //     c=1;
            //     //System.out.println(max);
            // }
            // System.out.println(max);
            //System.out.print(1+" ");
            //int cnt=1;
            //int mask=0;
            int a[]=new int[max];
            Arrays.fill(a,-1);
            //a[0]=ch[0]-'0';
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<max;j++)
                if(a[j]!=(ch[i]-'0'))
                {a[j]=ch[i]-'0';l.add(j+1);break;}
                //System.out.println();
                //System.out.println(" "+a[0]+" "+a[1]+" "+a[2]+" ");

            }
            for(int i=0;i<max;i++)
            if(a[i]==-1)
            {max=i-1;break;}
            System.out.println(max+1);
            for(int i=0;i<l.size();i++)
            System.out.print(l.get(i)+" ");


            System.out.println();
        }
        sc.close();
    }
    public static void method2(int n,char ch[]){
        int dp[]=new int[n+1][2];
        dp[n][0]=Integer.MAX_VALUE;
        dp[n][1]=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            dp[i][0]=ch[i]=='0'?i:dp[i+1][0];
            dp[i][1]=ch[i]=='1'?i:dp[i+1][1];
        }
        int p[]=new int[n];
        int pos=-1,cnt=1;
        char st;
        for(int i=0;i<n;i++)
        {
            if(pos==-1){
                st = 
            }
            pos = dp[pos+1][ch[i]-'0'];

            if(pos==Integer.MAX_VALUE)
            {
                cnt+=1;
                pos=-1;
            }
            
            pos=dp[pos][ch[i]-'0'];
        }
    }
}