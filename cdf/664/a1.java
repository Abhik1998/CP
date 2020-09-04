import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int r=sc.nextInt();
            int g=sc.nextInt();
            int b=sc.nextInt();
            int w=sc.nextInt();
            int min = Math.min(r,Math.min(b,g));
            b-=min;
            g-=min;
            r-=min;
            if(((min+w)&1)!=0)
            {
                if(b%2==1||r%2==1||g%2==1)
                {
                    System.out.println("No");
                    continue;
                }
                System.out.println("Yes");
            }
            else
            {
                int c=0;
                if(b%2==1)
                c+=1;
                if(g%2==1)
                c+=1;
                if(r%2==1)
                c+=1;
                //System.out.println(c);
                if(c>1)
                {
                    System.out.println("No");
                    continue;
                }
                System.out.println("Yes");


            }

        }
    }
}

