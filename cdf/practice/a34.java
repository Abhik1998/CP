import java.util.*;
public class a34{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        int k=0,l=-1,c=1;
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<n;i++){
            if(a[i]<=a[i-1])
            {
                if(a[i+1]-a[i-1]>=2)
                {
                    if(c==0)
                    {
                        k = q.poll();
                        q.add(i);
                        c=1;
                    }
                    else
                    {
                        c-=1;
                        q.add(i);
                    }
                }
                else{
                    l=Math.max(l,i-k+1);
                    k=i;
                    q.clear();
                }
                l=Math.max(l,i-k+1);
                


            }
            

        }
        System.out.println(l);



    }
}