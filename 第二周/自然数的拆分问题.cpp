#include<iostream>
using namespace std;
int a[100],n,m;
void dfs(int dep,int pre,int sum) {

    if(sum==n) {
        for(int i=1; i<=dep-1; i++) {
            cout<<a[i];
            if(i!=dep-1)
                cout<<"+";
        }
        cout<<"\n";
        return ;
    }
    for(int i=pre; i<=n-1; i++) {
        if(sum+i<=n) {
            a[dep]=i;
            dfs(dep+1,i,sum+i);
        }
    }
}
int main() {
    cin>>n;       
    dfs(1,1,0);

    return 0;
}

