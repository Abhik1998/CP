import java.util.*;
public class a31{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int B[][]=new int[r][2];
        for(int i=0;i<r;i++)
        {
            B[i][0]=sc.nextInt();
            B[i][1]=sc.nextInt();
        }

    }
    public static int find(int p[],int i){
        if(p[i]==i)
        return i;
        int res = find(p,p[i]);
        p[i]=res;
        return res;
    }
}