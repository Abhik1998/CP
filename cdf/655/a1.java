import java.util.*;
public class a1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            for(int i=0;i<n;i++)
            {
                if(i==499)
                {
                    i=0;
                    n-=499;
                }
                System.out.print((2*i+1)+" ");
            }
            
            System.out.println();

        }
        sc.close();
    }
}