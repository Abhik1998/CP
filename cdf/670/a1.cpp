#include <bits/stdc++.h>
#include<cstdio>
#include<iostream>
#define _ std::ios_base::Init i; std::ios_base::sync_with_stdio(false); std::cin.tie(0);

using namespace std;
vector<int> Centroid(vector<vector<int>> &g) {
        int n = g.size();
        vector<int> centroid;
        vector<int> sz(n);
        function<void (int, int)> dfs = [&](int u, int prev) {
                sz[u] = 1;
                bool is_centroid = true;
                for (auto v : g[u]) if (v != prev) {
                        dfs(v, u);
                        sz[u] += sz[v];
                        if (sz[v] > n / 2) is_centroid = false;
                }
                if (n - sz[u] > n / 2) is_centroid = false;
                if (is_centroid) centroid.push_back(u);
        };
        dfs(0, -1);
        return centroid;
}

int main(){
    int t;
    cin>>t;
    while(t-->0){
        int n;
        cin>>n;
        vector<vector<int>> g(n+1);
        for(int i=0;i<n-1;i++)
        {
            int a,b;
            cin>>a>>b;
            //addEdge(g,a,b);
            a-=1;
            b-=1;
            g[a].push_back(b);
        }

        auto centroids = Centroid(g);
        if (centroids.size() == 1) {
                int c = centroids[0];
                cout<<c<<" "<<g[c][0]<<endl;
                cout<<c<<" "<<g[c][0]<<endl;
        } else if (centroids.size() == 2) {
                int c1 = centroids[0];
                int c2 = centroids[1];
                cout<<c1<<" "<<g[c1][0]<<endl;
                cout<<c2<<" "<<g[c1][0]<<endl;
        }


    }
    return 0;
}