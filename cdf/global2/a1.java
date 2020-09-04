import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            String m="";
            for(int i=0;i<n;i++)
            m+=s.charAt(2*i);
            System.out.println(m);
        }
        sc.close();
    }
}