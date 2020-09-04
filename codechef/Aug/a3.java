import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int pc=sc.nextInt();
            int pr=sc.nextInt();
            int d1=pc/9 + (pc%9==0?0:1);
            int d2=pr/9 + (pr%9==0?0:1);
            if(d1<d2)
            System.out.println("0 "+d1);
            else
            System.out.println("1 "+d2);

        }
        sc.close();
    }
}