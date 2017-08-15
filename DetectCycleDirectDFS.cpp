//Check for cycle in Directed Graph using DFS 

#include <bits/stdc++.h>
using namespace std;
std::vector<int> adj[10000];
int edge, vertex;
bool vis[1000]={false};
int parent[1000]={0};

bool DetectCycleDirectDFS(int start){
	vis[start]=true;
	parent[start]=1;
	for(int i=0; i<adj[start].size(); i++){
		if(!vis[adj[start][i]] && DetectCycleDirectDFS(adj[start][i])) return true;
		else if(parent[adj[start][i]]) return true;
	}
	parent[start]=0;
	return false;
}

int main(){
	int x, y;
	cin>>edge>>vertex;
	for(int i=0; i<edge; i++){
		cin>>x>>y;
		adj[x].push_back(y);
		//adj[y].push_back(x);
	}
	//dfs(1);
	//bfs(1);
	int flag=0;
	for(int i=0; i<=vertex; i++){
		if(!vis[i]){
			if(DetectCycleDirectDFS(i)){
				flag=1;
				break;
			}
		}
	}
	flag == 1? cout<<"Cycle\n":cout<<"NO cycle\n";
	for(int i=0; i<=7; i++) cout<<parent[i]<<" ";
	return 0;
}