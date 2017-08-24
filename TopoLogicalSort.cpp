#include <bits/stdc++.h>
using namespace std;
std::vector<int>  adj[1000]; 
stack<int> order;
void topologicalSort(int v, bool vis[]){
	vis[v]=true;
	for(int j=0; j<adj[v].size(); j++){
		if(!vis[adj[v][j]])
			topologicalSort(adj[v][j], vis);
	}
	order.push(v);
}

int main(){
	int vertex, edge, x, y;
	cin>>vertex>>edge;
	for(int i=0; i<edge; i++){
		cin>>x>>y;
		adj[x].push_back(y);
	}
	bool *vis = new bool[vertex+1];
	for(int i=0; i<=vertex; i++)  vis[i]=false;
	for(int i=0; i<vertex; i++){
		if(!vis[i])
			topologicalSort(i, vis);
	}
	while(!order.empty()){ 
		cout<<order.top()<<" ";
		order.pop();
	}
	return 0;
}