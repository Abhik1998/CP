import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class a1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
        while(t-->0){
            int x=0;
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            boolean fl=false;
            for(x=0;x<(int)Math.pow(2,n);x++){
                int tk=Integer.bitCount(x);
                int ab[]=new int[tk];
                int bc[]=new int[n-tk];
                int a1=0,b1=0;
                for(int i=0;i<n;i++)
                if((x&(1<<i))!=0)
                ab[a1++]=a[i];
                else
                bc[b1++]=a[i];
                a1=mergeSortAndCount(ab, 0, tk-1);
                b1=mergeSortAndCount(bc, 0, n-tk-1);
                if(a1==b1)
                {
                    System.out.println("YES");
                    fl=true;
                    break;
                }
            }
            if(!fl)
            System.out.println("NO");
        }

        sc.close();
    }
    public static int mergeAndCount(int[] arr, int l, int m, int r) 
    { 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
    public static int mergeSortAndCount(int[] arr, int l, int r) 
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        int count = 0; 
  
        if (l < r) { 
            int m = (l + r) / 2; 
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        } 
  
        return count; 
    } 
}