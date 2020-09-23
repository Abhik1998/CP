#include<bits/stdc++.h>
#define ll long long
#define nes ios_base :: sync_with_stdio(0); cin.tie(0);
using namespace std;
string lcs(string &s,string & S){
	int n=s.size(),m=S.size();
	int dp[n+1][m+1];
	for(int i=0;i<=n;++i){
		for(int j=0;j<=m;++j){
			if(i==0||j==0) dp[i][j]=0;
			else if(s[i-1]==S[j-1]) dp[i][j]=dp[i-1][j-1]+1;
			else dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
		}
	}

	int i=n,j=m;
	string res="";
	while(i>=1&&j>=1){
		if(s[i-1]==S[j-1]){
			res.push_back(s[i-1]);
			--i;
			--j;
		}
		else if(dp[i][j-1]>=dp[i-1][j]) --j;
		else --i;
	}
	reverse(res.begin(),res.end());
	//cout<<"\n"<<res;
	return res;
}
int main(){
	nes;
	string s,S;
	cin>>s>>S;
	cout<<lcs(s,S);
	return 0;
}
