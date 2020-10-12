import java.util.*;
public class con3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
		for (int z = 0; z < t; ++z) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			
			int cs = 0;
			int los = 0;
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i)=='W') {
					++cs;
					if (i>0&&s.charAt(i-1)=='W')
						++cs;
				} else {
					++los;
				}
			}
			if (k==0) {
				System.out.println(cs);
				continue;
			}
			if (cs==0) {
				System.out.println(k*2-1);
				continue;
			}
			if (k>=los) {
				System.out.println(n*2-1);
				continue;
			}
			int bet = -10000000;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i)=='W') {
					if (bet>0)
						pq.add(bet);
					bet = 0;
				} else {
					++bet;
				}
			}
			cs += 2*k;
			while (!pq.isEmpty()) {
				int np = pq.poll();
				if (np>k)
					break;
				k-=np;
				++cs;
			}
			System.out.println(cs);
        }
    }
}