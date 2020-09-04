import java.util.*;
public class a3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            //int n=sc.nextInt();
            String s=sc.next();
            int n=s.length();
            HashMap<String,Integer> h=new HashMap<>();
            int max=0;
            for(int i=0;i<n-1;i++)
        {
            String m = s.charAt(i)+""+s.charAt(i+1);
            if(!h.containsKey(m))
            h.put(m,1);
            else
            h.put(m,h.get(m)+1);
            max = Math.max((int)h.get(m),max);

        }
        int a[]=new int[10];
        for(int i=0;i<n;i++)
        a[s.charAt(i)-'0']+=1;
        int maxi=0;
        for(int i=0;i<10;i++)
        maxi = Math.max(maxi,a[i]);

        System.out.println(Math.min(n-(max*2),n-maxi));


        }
        sc.close();
    }
}