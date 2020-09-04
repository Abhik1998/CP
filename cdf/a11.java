import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class a11{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt()-1;
        //HashMap<Integer, List<Integer>> g=new HashMap<>();
        //boolean b[]=new boolean[n+1];
        //ong a=0,b=0;
        int a[]=new int[n-1];
        //int c=0;
        for(int i=0;i<n-1;i++)
        a[i]=sc.nextInt();
        int i=0;
        while(i<t) {i=i+a[i];}
        if(i==t)
        System.out.println("YES");
        
        else
        System.out.println("NO");
        sc.close();
        
    }
}