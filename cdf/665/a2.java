import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                min=Math.min(min,a[i]);
            }
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++)
            if(a[i]%min!=0)
            l.add(a[i]);
            int fl=0;
            for(int i=1;i<l.size();i++)
            if(l.get(i)<l.get(i-1))
            {
                fl=1;
            }
            int b[]=new int[n];
            for(int i=0;i<n;i++)
            b[i]=a[i];
            Arrays.sort(b);
            for(int i=0;i<n;i++)
            {
                if((a[i]%min==0&&b[i]%min!=0)||(a[i]%min!=0&&b[i]%min==0))
                fl=1;
                //System.out.println(a[i]+" "+b[i]);
            }

            if(fl==0)
            System.out.println("YES");
            else
            System.out.println("NO");

        }
        sc.close();
    }
}