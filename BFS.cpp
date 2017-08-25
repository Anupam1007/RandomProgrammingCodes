#include<iostream>
#include<list>
#include<deque>
using namespace std;
class createList
{
    int V;
    list<int> *adj;
public:
    createList(int totalNumberOfNodes)
    {
        this->V=totalNumberOfNodes;
        adj = new list<int>[V];
    }
    void addEdge(int from, int to)
    {
        this->adj[from].push_back(to);
    }
    void printGraph()
    {
        for(int i=0;i<this->V;i++)
        {
            for(list<int>::iterator it = adj[i].begin();it!=adj[i].end();it++)
            {
                cout<<*it<<"\t";
            }
            cout<<endl;
        }
    }
    void bfs(int startVertex)
    {
        list<int> q;  //list is being used as a queue
        bool arr[this->V];
        for(int i=0;i<this->V;i++)
            arr[i]=false;
        q.push_back(startVertex);
        arr[startVertex]=true;

        list<int>::iterator it;
        while(!q.empty())
        {
            int s=q.front();
            cout<<s<<"\t";
            q.pop_front();

            for(it=adj[s].begin();it!=adj[s].end();it++)
            {
                if(arr[*it] != true)
                q.push_back(*it);
                arr[*it]=true;
            }

        }
    }
};
int main()
{
    createList g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    //g.printGraph();
    g.bfs(2);


    return 0;
}
