import java.util.*;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int z1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int z2=sc.nextInt();
            int sum = 0,a=0,b=0,c=0;
            if(z1>y2)
            {
                sum+=y2*2;
                z1-=y2;
                if(z1>z2)
                {
                    z1-=z2;
                    z2=0;
                    x2-=z1;
                    z1=0;
                    
                }
                else
                {
                    z1=0;
                    z2=z2-z1;


                }
            }


        }
        sc.close();
    }
}