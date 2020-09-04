import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=t;
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            int max=0,d=0,l=2;
            d=a[1]-a[0];
            for(int i=2;i<n;i++){
                if(a[i]-a[i-1]==d)
                l+=1;
                else{
                    max = Math.max(l,max);
                    l=2;
                    d=a[i]-a[i-1];
                }
            }
            max = Math.max(l,max);
            System.out.println("Case #"+(k-t)+": "+max);
        }
        sc.close();
    }
}