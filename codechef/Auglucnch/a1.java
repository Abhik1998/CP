import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            int f[]=new int[11];
            int cnt=0,k=0;
            //HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
                f[a[i]]+=1;
                if(f[a[i]]==1)
                cnt+=1;
            }
            int b[]=new int[cnt];
            for(int i=0;i<11;i++)
            if(f[i]!=0)
            b[k++]=f[i];
            mode(b,cnt);

            // for(int i=0;i<11;i++)
            // if(f[i]!=0)
            // {
            //     if(map.containsKey(f[i]))
            //     map.put(f[i],map.get(f[i])+1);
            //     else
            //     map.put(f[i],1);
            // }
            // int max=-1,val=-1;
            // for(int i=0;i<11;i++)
            // {
            //     if(f[i]!=0&&map.get(f[i])>max)
            //     {
            //         max=map.get(f[i]);
            //         val=f[i];
            //     }
            //     //System.out.println(f[i]);
            // }


            // System.out.println(val);

        }
    }
    static void mode(int[] a, int n) 
    { 
        // The output array b[] will 
        // have sorted array 
        //int []b = new int[n]; 
  
        // variable to store max of 
        // input array which will 
        // to have size of count array 
        int max = Arrays.stream(a).max().getAsInt(); 
  
        // auxiliary(count) array to 
        // store count. Initialize 
        // count array as 0. Size 
        // of count array will be 
        // equal to (max + 1). 
        int t = max + 1; 
        int[] count = new int[t]; 
        for (int i = 0; i < t; i++)  
        { 
            count[i] = 0; 
        } 
  
        // Store count of each element 
        // of input array 
        for (int i = 0; i < n; i++) 
        { 
            count[a[i]]++; 
        } 
  
        // mode is the index with maximum count 
        int mode = 0; 
        int k = count[0]; 
        for (int i = 1; i < t; i++)  
        { 
            if (count[i] > k) 
            { 
                k = count[i]; 
                mode = i; 
            } 
        } 
  
        System.out.println(mode); 
    } 
}