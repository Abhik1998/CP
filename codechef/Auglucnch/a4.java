import java.util.*;
public class a4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++)
            if(map.containsKey(a[i]))
            map.put(a[i],map.get(a[i])+1);
            else
            map.put(a[i],1);
            double min = Double.MAX_VALUE;
            for(int i=0;i<n;i++){
                min = Math.min(min,(double)(d+1)/map.get(a[i]));
            }
            System.out.println(min);
        }
    }
}