import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String s=sc.next();
            String p=sc.next();
            int a[]=new int[26];
            for(int i=0;i<s.length();i++)
            a[s.charAt(i)-'a']+=1;
            for(int i=0;i<p.length();i++)
            a[p.charAt(i)-'a']-=1;
            int f=p.charAt(0)-'a';
            StringBuilder m=new StringBuilder();
            int l=p.charAt(1)-'a';
            for(int i=1;i<p.length();i++)
            {
                l=p.charAt(i)-'a';
                if(l!=f)
                break;
            }
            if(l<f) f-=1;
            for(int i=0;i<=f;i++)
            {
                while(a[i]-->0)
                m.append((char)(i+97));
                //m+=(char)('a'+i);
            }
            m.append(p);
            //int l=p.charAt(p.length()-1)-'a';
            for(int i=f+1;i<26;i++)
            {
                while(a[i]-->0)
                m.append((char)(i+97));
                //m+=(char)('a'+i);
            }
            System.out.println(m.toString());


        }
    }
}