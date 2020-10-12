#include<bits/stdc++.h>
using namespace std;
#define  pp push_back
#define F first
#define S second
 

void  input()
{
   int n, m; cin >> n >> m;
   std::vector<pair<int, int> > V[n];
   
   for (int i = 0; i < m; ++i)
   {
        int u, v, w; cin >> u >> v >> w;
        u--;v--;
        V[u].pp({v, w});
        V[v].pp({u, w});
   }

   int f[n];
   for (int i = 0; i < n; ++i)
   {
       cin >> f[i];
   }

   map<int, int > fuel;
   for (int i = 0; i < n; ++i)
   {
       fuel[f[i]] = 0;
   }

   int K = fuel.size();
   std::vector<int> sorted_fuel;
   int count = 0;
   for(auto &it: fuel)
   {
      it.S = count++;
      sorted_fuel.pp(it.F);
   }


   vector< pair<int, int> > adj[n*K];

   for(int x = 0; x < n; x++)
   {
        for(auto it: V[x])
        {
            int y = it.F;
            int w = it.S;
            for(int k = 0; k < K; k++)
            {
                int x1 = x + k*n;
                int y1 = y + k*n;
                adj[x1].pp({y1, w*sorted_fuel[k]});
            }

            for(int k = fuel[f[x]]+1; k < K; k++)
            {
                int x1 = x + k*n;
                int y1 = x + fuel[f[x]]*n;
                adj[x1].pp({y1, 0});
            } 

        }

   }

   int p, q; cin >> p >> q; p--;q--;

   vector<int> dis(n*K , -1);
   dis[p+fuel[f[p]]*n] = 0;



   

   int T = 2*n;


   while(T--)
   {
     for(int x = 0; x < n*K; x++)
     {
        if(dis[x] == -1)
            continue;
        for(auto it: adj[x])
        {
            int y = it.F;
            int w = it.S;
            if(dis[y] == -1 || dis[y] > dis[x]  + w)
            {
                dis[y] = dis[x]  + w;
            }  
        }
     }
   }


   int ans = INT_MAX;


   for(int k = 0; k < K; k++)
   {
       if(dis[q+k*n] != -1)
            ans = min(ans, dis[q+k*n]);
   }


  cout << ans << endl;

}




int main()
{

    
     int t; cin >> t;
     while(t--)
        input();
  
   return 0;
}