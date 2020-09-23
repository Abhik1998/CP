//Author Abhik Chakraborty
import java.util.*;
public class sol1
{
    static ArrayList<String> lt;
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n=sc.nextInt();
        System.out.println("Enter the number of edges");
        int m=sc.nextInt();
        ArrayList<Integer> g[]=new ArrayList[5];
        
	    for(int i=0;i<n;i++)
	    g[i]=new ArrayList<Integer>();
        System.out.println("Enter the edges");
        for(int i=0;i<m;i++){
            int u=sc.nextInt(),v=sc.nextInt();
            g[u].add(v);
        }
	    
		System.out.println("Paths are "+paths(g,n));
	}
	
	public static ArrayList<String> paths(ArrayList<Integer> g[],int n){
	    lt=new ArrayList<>();
	    for(int i=0;i<n;i++){

	        helperUtil(g,n,i,new String());
	        
        }
        System.out.println("Path count "+lt.size());
	    return lt;
	}
	public static void helperUtil(ArrayList<Integer> g[],int n,int u,String s){
	    if(s.indexOf(u)>=0)
	    return;
	    s+=" "+u;
	    lt.add(s.trim());
	    for(int i=0;i<g[u].size();i++)
	    {
	        int in = g[u].get(i);
	        helperUtil(g,n,in,s);
	    }
	}
}