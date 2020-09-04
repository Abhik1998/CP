import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            char ch[]=sc.next().toCharArray();
            int c=0,fl=0;
            for(int i=1;i<n;i++)
            if(ch[i-1]==ch[(i+1)%n]&&ch[i]==ch[i-1])
            {
                c+=1;
                if(i==n-1)
                fl=1;
                i+=2;
                
            }
            
            System.out.println(c);

        }

    }
}