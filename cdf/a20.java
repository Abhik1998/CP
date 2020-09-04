import java.util.*;
public class a20{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n-1];
        int sum = 0;
        for(int i=1;i<n;i++)
        {
            b[i]=Math.abs(a[i]-a[i-1]);
            sum+=b[i] * (int)Math.pow(-1,i-1);
        }
        
    }
    public static int maxit(int a[],int n,int sum){
        int i=0,j=n-1;
        
    }
}