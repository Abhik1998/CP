import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char ch1[]=sc.next().toCharArray();
        char ch2[]=sc.next().toCharArray();
        int ur=0,p1=0,p2=0,n=ch1.length;
        for(int i=0;i<n;i++)
        {
            p1 += (ch1[i]=='+')?1:-1;
            if(ch2[i]=='?')
            ur+=1;
            else
            p2 += (ch2[i]=='+')?1:-1;
        }
        double prob = 0;
        if(ur==0)
        {
            if(p1!=p2)
            prob=0;
            else
            prob=1;
        }
        else{
            
            if(Math.abs(p1-p2)>ur||(Math.abs(p1-p2)%2!=ur%2))
            prob=0;
            else
            if(Math.abs(p1-p2)==ur)
            prob  = (double)Math.pow(2,-ur);
            else{
                int tu=(Math.abs(p1-p2) + ur)/2;
                //System.out.println(select(ur,tu)+" "+tu);
                prob = (double)select(ur,tu)/Math.pow(2,ur);

            }
        }
        System.out.println(prob);
    }
    public static int select(int n,int r){
        int k =Math.max(r,n-r);
        int l =n-k;
        int p=1;
        for(int i=k+1;i<=n;i++)
        p*=i;
        for(int i=1;i<=l;i++)
        p/=i;
        return p;

        
    }
}