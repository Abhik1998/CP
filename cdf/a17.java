import java.io.*;
import java.util.*;
public class a17{
    public static void main(String[] args)throws Exception {
    File file = new File("/home/abhik/Downloads/alchemy_input.txt"); 
  
    BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  //String st; 
 // while ((st = br.readLine()) != null) 
    
        //Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(br.readLine());
        int t1=t;
        while(t-->0){
            int n=Integer.parseInt(br.readLine());;
            int a=0,b=0;
            String s=br.readLine();
            for(int i=0;i<n;i++)
            {
                if(s.charAt(i)=='A')
                a+=1;
                else
                b+=1;
            }
            if(Math.abs(a-b)==1)
            System.out.println("Case #"+(t1-t)+": Y");
            else
            System.out.println("Case #"+(t1-t)+": N");
        }
        //sc.close();
    }
}