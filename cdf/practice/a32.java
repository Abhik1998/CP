import java.util.*;
public class a32{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int sum=0,max=0;
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                sum+=a[i];
                max=Math.max(max,a[i]);
            }
            if(max*2>sum || (sum&1)==1)
            System.out.println("T");
            else
            System.out.println("HL");

            
            
        }
    }
}