import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            long sum=0,max=0;
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum = (long)sum + a[i];
                max = Math.max(a[i],max);
            }
            List<Integer> l=new ArrayList<>();
            for(int i=1;i<=(int)sum/max;i++)
            if(sum%i==0)
            l.add((int)sum/i);

            Collections.sort(l);
            int count =1;
            for(int i=0;i<l.size();i++)
            {
                int fl=1;
                for(int j=1;j<n;j++)
                if(a[j]!=a[j-1]&&(a[j]+a[j-1])>l.get(i))
                {
                    fl=0;
                    break;

                }
                else{

                    a[j] += a[j-1];
                    if(a[j]==l.get(i))
                    j+=1;
                }
                //int count =1;
                if(fl==1)
                count = (int)sum / l.get(i);
            }
            System.out.println(count);


        }
    }
}