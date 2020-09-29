import java.util.*;
import java.io.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            boolean fl=true;
            
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                if((i+1)%a[i]!=0)
                    {
                        fl=false;
                    }
                
                    
            }
            
            if(!fl)
            System.out.println("NO");
            else
            System.out.println("YES");


        }
        sc.close();
    }
}