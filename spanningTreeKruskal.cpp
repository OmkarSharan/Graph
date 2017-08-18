#include <bits/stdc++.h>
using namespace std;

int j=0;
pair<int, pair<int, int> > adj[1000]; // pair<wieght, pair<x, y> >
pair<int, pair<int, int> > path[100]; // to print edges of spanning tree
int Parent(int set[],int x){
	while(x!=set[x]){
		x=set[x];
	}
	return x;
}

void Union(int set[], int u, int v){
	int rootU=Parent(set, u);
	int rootV=Parent(set, v);
	if(rootU!=rootV){
		set[rootU]=rootV;
	}
}

bool Find(int set[],int u, int v){
	int rootU=Parent(set, u);
	int rootV=Parent(set, v);
	if(rootU==rootV) return true;
	return false;
}

int Kruskal(int set[], int edge){
	int min=0;
	for(int i=0; i<edge; i++){
		int u=adj[i].second.first;
		int v=adj[i].second.second;
		if(!Find(set, u, v)){
			min+=adj[i].first;
			path[j]=make_pair(adj[i].first, make_pair(adj[i].second.first, adj[i].second.second));
			j++;
			Union(set, u, v);
		}
	}
	return min;
}

int main(){
	int edge, vertex, x, y, w;
	cin>>edge>>vertex;
	int set[100];
	for(int i=0; i<=vertex; i++) set[i]=i;
	for(int i=0; i<edge; i++){
		cin>>x>>y>>w;
		adj[i]=(make_pair(w,make_pair(x, y)));
		//adj[y].insert(make_pair(x, w));
	}
	sort(adj, adj+edge);
	cout<<"cost of minimum spannig tree is: "<<Kruskal(set, edge)<<endl;
	cout<<"minimum spannig tree edges are: \n";
	for(int i=0; i<j; i++){
		cout<<path[i].second.first<<" "<<path[i].second.second<<" "<<path[i].first<<endl;
	}
}
