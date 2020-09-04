import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<m;j++)
                a[i][j] = s.charAt(j)-'0';
        }
        int q=sc.nextInt();
        int b[][]=new int[n][m];
        while(q-->0){
            int x1=sc.nextInt(),y1=sc.nextInt(),x2=sc.nextInt(),y2=sc.nextInt();
            for(int i=x1-1;i<x2;i++)
            for(int j=y1-1;j<y2;j++)
            b[i][j]+=1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            System.out.print(a[i][j]+b[i][j]);
            System.out.println();
        }
    }
}