import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int min=Integer.MAX_VALUE,num=-1;
            for(int i=0;i<n;i++){
                int val=sc.nextInt();
                int temp = (k%val==0)?(k/val)-1:-1;
                if(temp!=-1 && min>temp)
                {
                    min=temp;
                    num=val;
                }
                
            }
            System.out.println(num);
        }
    }
}