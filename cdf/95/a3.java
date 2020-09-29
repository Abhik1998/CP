import java.util.*;

import jdk.internal.util.xml.impl.Pair;
public class a3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];


        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        a[i][j]=sc.nextInt();
        Pair<Integer,Integer> p[][]=new Pair[n][m];
        int cnt=0;
        HashMap<ArrayList<Integer>,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    p[i][j]=new Pair<Integer,Integer>(i,j);
                    int sz[]=new int[1];
                    ArrayList<Integer> l1=new ArrayList<>();
                    l1.add(i);l1.add(j);
                    dfsUtil(a,i,j,n,m,p,sz);
                    cnt+=1;
                    map.put(l1,sz[0]);
                }
            }
        vis=new boolean[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    
                }
            }

    }
    public static void dfsUtil(int a[][],int i,int j,int n,int m,Pair<Integer,Integer> p[],int size[]){
        if(i<0||j<0||i>=n||j>=m)
            return;
        size[0]+=1;
        if(i>0&&!vis[i-1][j]&&a[i-1][j]==a[i][j])
        {
            p[i-1][j]=p[i][j];
            dfsUtil(a, i-1, j, n, m, p, size);
        }
        if(i<n-1&&!vis[i+1][j]&&a[i+1][j]==a[i][j])
        {
            p[i+1][j]=p[i][j];
            dfsUtil(a, i+1, j, n, m, p, size);
        }
        if(j>0&&!vis[i][j-1]&&a[i][j-1]==a[i][j])
        {
            p[i][j-1]=p[i][j];
            dfsUtil(a, i, j-1, n, m, p, size);
        }
        if(j<m-1&&!vis[i][j+1]&&a[i][j+1]==a[i][j])
        {
            p[i][j+1]=p[i][j];
            dfsUtil(a, i, j+1, n, m, p, size);
        }


    }
}