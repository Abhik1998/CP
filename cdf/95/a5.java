import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class a5 {

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new FastScanner(in);
		
		
		int n =sc.nextInt();
		m = sc.nextLong();
		map = undirected(n);
	//	System.out.println(m);
		
		an = new long[n+1];
		dfs(1 , -1);
		partochild(1, 1);
		for(int i =1 ;i<an.length ;i++) {
			out.println(an[i]);
		}
		out.flush();
	}
	private static void partochild(int cur , long from_parent) {
		if(map.get(cur).size()==0)return ;
		long [] arr = dp.get(cur);
		long[] pre = new long[arr.length];
		long[] suf = new long[arr.length];
		
		int n = arr.length; 
		pre[0]=1;
		for(int i = 1 ;i < n ;i++) {
			pre[i]= (pre[i-1]*arr[i-1])%m;
		}
		suf[n-1]=1;
		for(int i = n-2 ;i >=0 ;i--) {
			suf[i]=(suf[i+1]*arr[i+1])%m;
		}		
		
		
		
		
		int i = 0 ;
		for(int nbr : map.get(cur)) {
			
			long temp =( pre[i] * suf[i] )%m;
			temp = (temp * from_parent)%m;
		     temp = (temp + 1)%m;	
		     an[nbr] = (an[nbr] * temp)%m;
		     partochild(nbr, temp );
		     i++;
		}			
			
					
			
		
	}
	 private static long dfs(int cur, int par) {
		// Auto-generated method stub
		long ans = 1; 	
	//	System.out.println(map.get(cur));
		if(par!=-1)map.get(cur).remove(par);
		
		
		dp.put(cur, new long[map.get(cur).size()] );
		
		
		
		int i = 0 ;
  		for(int nbr : map.get(cur)) {
			if(nbr==par)continue;
			
			long temp = dfs(nbr ,cur)+1;
			
			temp%=m;
			dp.get(cur)[i] = temp;
			
			
			ans = (ans * temp)%m;
			i++;
		}
		 an[cur] = ans;
		 
		 return ans;
		 
	}
	 static long m ;
	static long [] an ; 
	 static TreeMap<Integer , TreeSet<Integer> >  map ; 
	
	 static TreeMap<Integer ,long[] >  dp =new TreeMap<Integer, long[]>(); 

	public static TreeMap<Integer , TreeSet<Integer> > undirected(int n ) throws Exception{
		TreeMap<Integer , TreeSet<Integer> > map = new TreeMap<>();
		for(int i = 1 ;i<=n ;i++)map.put(i, new TreeSet<Integer>());
		

		for(int i = 1 ;i < n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
		}
		return map;
	}
	
	static long mod = 1000000007;
	public static long[][] input(int n, int m) throws Exception {

		long[][] arr = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}
	
	
	
	static BufferedReader in;
	static FastScanner sc;
	static PrintWriter out;

	static class FastScanner {
		BufferedReader in;
		StringTokenizer st;

		public FastScanner(BufferedReader in) {
			this.in = in;
		}

		public String nextToken() throws Exception {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(in.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() throws Exception {
			return Double.parseDouble(nextToken());
		}
	}
	
}
