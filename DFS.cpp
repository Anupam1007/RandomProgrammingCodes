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
    void dfs(int startVertex)
    {
        bool arr[this->V];
        for(int i=0;i<this->V;i++)
            arr[i]=false;


        dfsUTIL(arr,startVertex);
    }
    void dfsUTIL(bool arr[],int startVertex)
    {
        cout<<startVertex<<"\t";
        arr[startVertex]=true;

        for(list<int>::iterator it=adj[startVertex].begin();it!=adj[startVertex].end();it++)
        {
            if(!arr[*it])
                dfsUTIL(arr,*it);
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
    g.dfs(2);

    return 0;
}
