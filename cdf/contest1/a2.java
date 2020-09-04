import java.util.*;
public class a2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            

            if(n>=31)
            {
                System.out.println("YES");
                if(n!=36&&n!=40&&n!=44)
                System.out.println(6+" "+10+" "+14+" "+(n-30));
                else
                if(n==36)
                System.out.println(5+" "+6+" "+10+" "+15);
                else
                if(n==40)
                System.out.println(5+" "+6+" "+14+" "+15);
                else
                System.out.println(7+" "+6+" "+10+" "+21);
            }
            else
            System.out.println("NO");

        }
        sc.close();
    }
}