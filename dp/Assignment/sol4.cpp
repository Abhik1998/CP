//SCC
#include <bits/stdc++.h>
using namespace std;
 
#define kk
#define F(a, b) for(int i=a; i<=b; i++)
#define REP(i, a, b) for(int i=a; i<=b; i++)
#define ff first
#define ss second
#define ll long long
#define inf 1000000000
#define pb push_back
#define mod 1000000007
 
const ll INF=1e18+5;
const int maxN=1e5+5;
typedef pair<int, int> pi;
 
vector<int> arr[maxN];
vector<int> t_arr[maxN];
bool vis[maxN];

vector<pi> out;
int timer=1;

vector<int> cc;

void dfsUtil1(int v){
	vis[v]=1;
	timer++;
	
	for(int child: arr[v]){
		if(vis[child]==0) dfsUtil1(child);
	}
	
	out.pb({v, timer++});
}

void dfsUtil2(int v){
	vis[v]=1;
	
	for(int child: t_arr[v]){
		if(vis[child]==0) dfsUtil2(child);
	}
	
	cc.pb(v);
}
// Add Edge function
void addEdge(int u,int v){
	arr[u].pb(v);
	t_arr[v].pb(u);
}

void solve(){
	int n;
	cin>>n;
	
	cin.ignore();
	
	// Input Operation
	while(1){
		string s, temp;
		getline(cin, s);
		stringstream ss(s);
		vector<int> v;
		while(getline(ss, temp, ' ')){
			v.push_back(stoi(temp));
		}
		
		if(v.size()==0) break;
		else{
			for(int i=1; i<(int)v.size(); i++)
				addEdge(v[0],v[i]);
		}
	}
	
	// Kosaraju's Algorithm Implementation
	F(1, n){
		if(vis[i]==0) dfsUtil1(i);
	}
	
	F(1, n) vis[i]=0;
	
	sort(out.begin(), out.end(), [&](pi a, pi b){
		return a.ss>b.ss;
	});
	
	cout<<"Connected components list - "<<endl;
	int cnt=0;
	
	for(int i=0; i<(int)out.size(); i++){
		int v=out[i].ff;
		
		if(vis[v]==0){
			cc.clear();
			dfsUtil2(v);
			cnt++;
			for(int x: cc){
				cout<<x<<" ";
			}
			cout<<endl;
		}
	}
	cout<<endl;
	cout<<"Total strongly connected components are "<<cnt<<endl;
}
 
 
signed main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cout<<fixed<<setprecision(6);
	
	#ifdef kk
	freopen("input.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
	#endif
	
	int T=1;
	
	while(T--){		
		solve();
	}
}