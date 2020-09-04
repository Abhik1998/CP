import java.util.*;
public class a5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char ch[][]=new char[n][m];
        for(int i=0;i<n;i++)
        ch[i]=sc.next().toCharArray();
        if(n>3||m>3||n==1||m==1)
        {
            System.out.println(-1);
            return;
        }
        if(n==2&&m==2){
            if(checkUtil(ch,0,0))
            System.out.println(0);
            else
            System.out.println(1);
            return;
        }
        if(n==2&&m==3){
            
        }
        

        
    }
    public static boolean checkUtil(char ch[][],int i,int j){
        return (ch[i][j]+ ch[i+1][j] + ch[i][j+1]+ch[i+1][j+1] - (4*'0'))%2==1;
    }
    
}