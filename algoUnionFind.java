import java.util.*;
class algoUnionFind
{
	int V,E;
	Edge edge[];
	class Edge
	{
		int src,dest;
	}
	algoUnionFind(int V,int E)
	{
		this.V=V;
		this.E=E;
		edge=new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]=new Edge();
		}
	}
	int find(int parent[],int temp)
	{
		if(parent[temp]==-1)
			return temp;
		return find(parent,parent[temp]);
	}
	void union(int parent[],int n,int m)
	{
		//int xset = find(parent, n); //these two lines are only present to generalise the union method, otherwise n and m are equal 
        //int yset = find(parent, m); //to xset and yset respectively so no need to write in this case. since it would produce same results.
		parent[n]=m;
	}
	boolean isCycle(algoUnionFind graph)
	{
		int[] parent = new int[this.V];
		Arrays.fill(parent,-1);
		
		for(int i=0;i<this.E;i++)
		{
			int x=find(parent,edge[i].src);
			int y=find(parent,edge[i].dest);
			
			if(x==y)
				return true;
			
			union(parent,x,y);
		}
		return false;
	}
	public static void main(String args[])
	{
		int V = 4, E = 3;
        algoUnionFind graph = new algoUnionFind(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
 
        if (graph.isCycle(graph)==true)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
		
	}
}