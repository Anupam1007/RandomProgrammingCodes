#include<iostream>
#include<list>
#include<deque>
#include<algorithm>
using namespace std;
class createList
{
    int V;
    list<int> *adj;
    bool isCycle ;
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
        bool stackTrace[this->V];
        for(int i=0;i<this->V;i++)
        {
            arr[i]=false;
            stackTrace[i]=false;
        }
        this->isCycle=false;

        dfsUTIL(arr,stackTrace,startVertex);
    }
    void dfsUTIL(bool arr[],bool stackTrace[],int startVertex)
    {
        //cout<<startVertex<<"\t";
        arr[startVertex]=true;

        for(list<int>::iterator it=adj[startVertex].begin();it!=adj[startVertex].end();it++)
        {
            if(!arr[*it] && !foundInTrace(*it,stackTrace))
               {
                    dfsUTIL(arr,stackTrace,*it);//very important note: dfsUTIL can also be called from condition itself for recursion, this would require to change foundInTrace function to include DFSUtil also
               }
            else
            {
                    this->isCycle=true;
            }
        }
    }
    bool foundInTrace(int startVertex,bool stackTrace[])
    {
        for(int i=0;i<V;i++)
        {
            if(startVertex == stackTrace[i])
                return true;
        }
        return false;
    }
    bool isTheGraphCycle()
    {
        return this->isCycle;
    }
};
int main()
{
    createList g(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    //g.addEdge(2, 0);
    //g.addEdge(2, 3);
    //g.addEdge(3, 3);
    g.dfs(0);

    if(g.isTheGraphCycle())
        cout<<"\n\n"<<"the graph has cycle";
    else
        cout<<"\n\n"<<"the graph doesn't have  cycle"<<endl;
    return 0;
}
