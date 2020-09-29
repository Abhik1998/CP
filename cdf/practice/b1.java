import java.util.*;
public class b1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String a=sc.next();
            String b=sc.next();
            int l=a.length();
            
            for(int i=0;i<l;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<=i;j++)
                    sb.append(1-(a.charAt(i)-'0'));
                
                a = sb.reverse().toString()+a.substring(i+1);
                if(a.equals(b))
                {
                    fl=1;
                    System.out.println
                }
            }
        }
    }
}