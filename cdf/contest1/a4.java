import java.util.*;
public class a4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();

        }
        sc.close();
    }
    public boolean[][] bfs(char ch[][],boolean vis[][],int n,int m, int i,int j){
        Queue<Pair<Integer,Integer>> q=new LinkedList<>();
        q.add(new Pair<Integer,Integer>(i,j));
        vis[i][j]=true;
        while(!q.isEmpty){
            int x = q.peek().getKey();
            int y = q.peek().getValue();
            q.poll();
            if(x+1<n&&!vis[x+1][y])
            {
                q.add(new pair<Integer,Integer>(x+1,y));
                vis[x+1][y]=true;
            }
            if(y+1<m&&!vis[x][y+1])
            {
                q.add(new pair<Integer,Integer>(x,y+1));
                vis[x][y+1]=true;
            }
            if(x>0&&!vis[x-1][y])
            {
                q.add(new pair<Integer,Integer>(x-1,y));
                vis[x-1][y]=true;
            }
            if(y>0&&!vis[x][y-1])
            {
                q.add(new pair<Integer,Integer>(x,y-1));
                vis[x][y-1]=true;
            }
        }
        return vis;
    }
}