#include <bits/stdc++.h>
using namespace std;
#define RED 1
#define BLUE 2
int K, V, E;
int visited[20001];

void bfs(int start, vector<int> adjacentNode[]) {
    queue<int> q;
    q.push(start);
    visited[start] = RED;
    
    while(!q.empty()) {
        int now = q.front();
        for(auto i : adjacentNode[now]) {
            if(visited[i] == 0) {
                q.push(i);
                if(visited[now] == RED) visited[i] = BLUE;
                else    visited[i] = RED;
            }
        }
        q.pop();
    }
}

int main()
{
    ios_base::sync_with_stdio(0);   cin.tie(0); cout.tie(0);
    
    cin >> K;
    while(K--) {
        cin >> V >> E;
        vector<int> adjacentNode[V+1];
        vector<pair<int, int>> edge;
        for(int i=1; i<=E; i++) {
            int u, v;
            cin >> u >> v;
            edge.push_back({u, v});
            adjacentNode[u].push_back(v);
            adjacentNode[v].push_back(u);
        }
        
        for(int i=1; i<=V; i++) {
            if(!visited[i]) bfs(i, adjacentNode);
        }
        
        bool flag = true;
        for(auto e : edge) {
            if(visited[e.first] == visited[e.second])   { flag = false; break;}
        }
        
        if(flag)   cout << "YES\n";
        else    cout << "NO\n";
        
        memset(visited, 0, sizeof(visited));
    }
}