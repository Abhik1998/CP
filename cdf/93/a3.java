import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            char ch[]=sc.next().toCharArray();
            int a[]=new int[n+1];
            HashMap<Integer,Integer> h=new HashMap<>();
            long c=0;
            h.put(0,1);
            for(int i=1;i<=n;i++)
            {
                a[i] = (ch[i-1]-'0') + a[i-1];
                
                if(h.containsKey(a[i]-i)) 
                c=(long) c+ h.get(a[i]-i);
                if(h.containsKey(a[i]-i))
                h.put(a[i]-i, h.get(a[i]-i)+1);
                else
                h.put(a[i]-i,1);
                //System.out.println(h);
                 
            }
            System.out.println(c);

            // c=0;
            // int b[]=new int[n];
            // for(int i=0;i<n;i++)
            // if(ch[i]=='1')
            // c+=1;
            // HashMap<Integer,Integer> h1=new HashMap<>();
            // for(int i=0;i<n;i++)
            // {
            //     b[i] = (ch[i]-'0')+ ((i==0)?0:b[i-1]);
            //     if(h1.containsKey(b[i]-i))
            //     c+=1;
            //     h1.put(b[i]-i,1);

            // }
            // System.out.println(c);

        }
        sc.close();

    }
}