import java.util.*;
public class a2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            char ch[]=sc.next().toCharArray();
            int n=ch.length,c=0;
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++)
            if(ch[i]=='1')
            c+=1;
            else
            {
                l.add(c);
                c=0;
            }
            l.add(c);
            Collections.sort(l);
            Collections.reverse(l);
            int sum=0;
            for(int i=0;i<l.size();i+=2)
            sum+=l.get(i);
            System.out.println(sum);
            
        }
        sc.close();

    }
}