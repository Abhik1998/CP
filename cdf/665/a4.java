import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int cost=0;
            if(k<n){
                cost = (n-k)%2==0?0:1;
            }
            else
            cost = Math.abs(k-n);
            System.out.println(cost);
        }
        sc.close();
    }
}