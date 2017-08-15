#include <bits/stdc++.h>
using namespace std;
std::vector<int> adj[10000];
int edge, vertex;
bool vis[1000]={false};

void dfs(int start){
	vis[start]=true;
	cout<<start<<" ";
	for(int i=0; i<adj[start].size(); i++){
		if(!vis[adj[start][i]])
			dfs(adj[start][i]);
	}
}

//detect cycle using dfs

bool DerectCycleDFS(int start, int parent){
	vis[start]=true;
	for(int i=0; i<adj[start].size(); i++){
		if(!vis[adj[start][i]]){
			if(DerectCycleDFS(adj[start][i], start)) return true;
		}
		else if(parent != adj[start][i]) return true;
	}
	return false;
}

void bfs(int start){
    vis[start]=1;
    queue<int>Q;
    Q.push(start);
    while(!Q.empty()){
        int current = Q.front();
        Q.pop();
        cout<<current<<" ";
        for(int i=0; i<adj[current].size(); i++){
            if(!vis[adj[current][i]]){
                vis[adj[current][i]]=1;
                Q.push(adj[current][i]);
            }
        }
    }
}
int main(){
	int x, y;
	cin>>edge>>vertex;
	for(int i=0; i<edge; i++){
		cin>>x>>y;
		adj[x].push_back(y);
		adj[y].push_back(x);
	}
	//dfs(1);
	//bfs(1);
	int flag=0;
	for(int i=1; i<=vertex; i++){
		if(!vis[i]){
			if(DerectCycleDFS(i, -1)){
				flag=1;
				break;
			}
		}
	}
	flag == 1? cout<<"Cycle\n":cout<<"NO cycle\n";
	return 0;
}