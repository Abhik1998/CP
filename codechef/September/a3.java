import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int v[]=new int[n];
            for(int i=0;i<n;i++)
            v[i]=sc.nextInt();
            int omax=-1,omin=10;
            
            for(int i=0;i<n;i++){
                int l=0,r=0,tot=1;
                for(int j=0;j<i;j++)
                l+=(v[i]<v[j])?1:0;
                for(int j=i;j<n;j++)
                r+=(v[i]>v[j])?1:0;
                tot+=l+r;
                
                int max=0;
                for(int j=0;j<i;j++){
                    max=Math.max(v[j],max);
                }
                for(int j=i+1;j<n;j++)
                if(v[j]>v[i]&&max>v[j])
                tot+=1;
                int min=10;
                for(int j=i+1;j<n;j++){
                    min=Math.min(v[j],min);
                }
                for(int j=0;j<i;j++)
                if(v[j]<v[i]&&v[j]>min)
                tot+=1;
                omax=Math.max(omax,tot);
                omin=Math.min(omin,tot);
                //System.out.println(l+" "+r+" "+tot);


            }
            System.out.println(omin+" "+omax);
            
        }
        
    }
}
/*
int x = n/3;
int y = n%3;
int c=0;
Queue<Integer> q=new LinkedList<>();
q.add(1);q.add(2);q.add(5);
while(c<n){
    int m=q.pop();
    q.push(m*10+1);
    c+=1;
    if(c==n)
    break;
    q.push(m*10+2);
    if(c==n)
    break;
    q.push(m*10+5);
    if(c==n)
    break;
}
int res=1;
while(!q.isEmpty())
{
    res=q.pop();
}
return res;

*/