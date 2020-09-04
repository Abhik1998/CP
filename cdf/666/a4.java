import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[26];
            String s[]=new String[n];
            for(int i=0;i<n;i++)
            s[i]=sc.next();
            for(int i=0;i<n;i++){
                for(int j=0;j<s[i].length();j++)
                a[s[i].charAt(j)-'a']+=1;
            }
            String m="YES";
            for(int i=0;i<26;i++)
            if(a[i]%n!=0)
            {
                m="NO";
                break;
            }
            System.out.println(m);
        }
    }
}