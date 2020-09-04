#include <iostream>
 
using namespace std;
 
int main()
{
    int n;
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++)
    cin>>a[i];
    if(n==1){
            cout<<"1 1"<<endl;
            cout<<-a[0]<<endl;
            cout<<"1 1"<<endl;
            cout<<0<<endl;
            cout<<"1 1"<<endl;
            cout<<0<<endl;
            return 0;
 
        }
        
        
        cout<<"1 "<<n<<endl;
                for(int i=0;i<n;i++)
                {
                    long long res = (long long)(-a[i])*n;
                    cout<<res<<" ";
                }
                cout<<endl;
                cout<<"1 "<<n-1<<endl;
 
                for(int i=0;i<n-1;i++)
                {
                    long long res = (long long)a[i]*(n-1);
                    cout<<res<<" ";
                }
                cout<<endl;
                cout<<"2 "<<n<<endl;
             for(int i=1;i<n-1;i++)
             cout<<0<<" ";
             cout<<((long long)a[n-1]*(n-1))<<endl;
 
                
 
 
    return 0;
}