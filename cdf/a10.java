import java.util.*;
public class a10{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int l=s.length();
        for(int i=1;i<l;i++){
            char ch=s.charAt(i);
            if(ch==s.charAt(i-1))
            System.out.print(ch+""+ch+" ");
        }
        

        sc.close();
    }
}