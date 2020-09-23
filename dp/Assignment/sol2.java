//Author Abhik Chakraborty
import java.util.*;
public class sol2
{
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    
	   ArrayList<Integer> g[]=new ArrayList[n];
	   for(int i=0;i<n;i++)
	   g[i]=new ArrayList<Integer>();
	   int in[]=new int[n];
	   int m=sc.nextInt();
	   for(int i=0;i<m;i++)
	   {
	       int u=sc.nextInt(),v=sc.nextInt();
	       g[u].add(v);
	       in[v]+=1;
       }
       System.out.print("Topological Sort order is: ");
       topoSort(g,in,n);
       System.out.println();
       sc.close();
	}
	public static void topoSort(ArrayList<Integer> g[],int in[],int n){
	    Queue<Integer> q=new LinkedList<>();
	    for(int i=0;i<n;i++)
	    if(in[i]==0)
	    q.add(i);
	    while(!q.isEmpty()){
	        int j=q.poll();
	        System.out.print(j+" ");
	        for(int i=0;i<g[j].size();i++)
	        {
	            
	            if((--in[g[j].get(i)])==0)
	            q.add(g[j].get(i));
	        }
	        
	    }
	}
}

