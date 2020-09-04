import java.util.*;
public class a5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            //int b[]=new int[l.size()];
            if(k==1){
            HashSet<Integer> h=new HashSet<>();
            int c=0;
            for(int i=0;i<n;i++){
                if(!h.contains(a[i]))
                h.add(a[i]);
                else
                {
                    c+=1;
                    h.clear();
                    h.add(a[i]);
                }
            }
            
            
            System.out.println(c+1);
        }
            else
            {
                Instant start = Instant.now();
                int getc = cost(a,new HashMap<Integer,Integer>(),k,0,k,start);
                if(getc==0)
                getc = costf(a,n,k);
                System.out.println(getc);
            }
            
            

        }

    }
    public static int cost(int a[],HashMap<Integer,Integer> map,int c,int i,int k,Instant start){
        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);

        if(interval >=1)
        return 0;
        if(i==a.length)
        return c;
        if(map.containsKey(a[i]))
        {
            HashMap<Integer,Integer> map1=new HashMap<>();
            map1.put(a[i],1);
            map.put(a[i],map.get(a[i])+1);
            if(map.get(a[i])==2)
            return Math.min(cost(a,map,c+2,i+1,k,start),cost(a,map1,c+k,i+1,k,start));
            return Math.min(cost(a,map,c+1,i+1,k,start),cost(a,map1,c+k,i+1,k,start));
            
        }
        map.put(a[i],1);
        return cost(a,map,c,i+1,k,start);

    }
    public static int costf(int a[],int n,int k){
        HashMap<Integer,Integer> h=new HashMap<>();
            ArrayList<Integer> l=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                //a[i]=sc.nextInt();
                if(!h.containsKey(a[i])) {h.put(a[i],1);l.add(a[i]);}
                else h.replace(a[i],h.get(a[i])+1);
            }
            //int b[]=new int[l.size()];
            int sum=0,max=0;
            for(int i=0;i<l.size();i++)
            {
                int nm=h.get(l.get(i));
                if(nm>1)
                sum+=nm;
                max=Math.max(nm,max);
            }

            //b[i]=h.get(l.get(i));
            
            
            //int min=Integer.MAX_VALUE;
            //for(int i=0;i<l.size();i++)
            int min = Math.min(max*k,sum+k);
            return min;
    }
}