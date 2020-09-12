import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[101];
            for(int i=0;i<n;i++)
            {
                int c=sc.nextInt();
                a[c]+=1;
            }
            int max=-1;
            for(int i=0;i<101;i++)
            if(a[i]==0)
            {
                if(max==-1)
                max=2*i;
                else
                max+=i;
                break;
            }
            else
            if(a[i]==1&&max==-1)
            {
                max=i;
                
            }
            System.out.println(max);
            
            
        }
        sc.close();
    }
}