class UnionByRankAndPathCompression
{
	private int V,E;
	 Edge edge[];
	UnionByRankAndPathCompression(int V,int E)
	{
		this.V=V;
		this.E=E;
		
		edge=new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]=new Edge();
		}
	}
	class Edge
	{
		int src,dest;
	}
	void addEdge(int e,int src,int dest)
	{
		this.edge[e].src=src;
		this.edge[e].dest=dest;
	}
	
	int findPathCompression(int arr[],int vertex)
	{
		if(arr[vertex]!=vertex)
			return findPathCompression(arr,arr[vertex]);
		
		return arr[vertex];
	}
	
	void UnionByRank(int arr[],int rank[],int src,int dest)
	{
		int xint=findPathCompression(arr,src);
		int yint=findPathCompression(arr,dest);
		
		if(rank[xint] < rank[yint])
			arr[src]=dest;
		else if(rank[yint] < rank[xint])
			arr[dest]=src;
		else
		{
			//else make anyone parent and increase rank by one.
			arr[src]=dest;
			rank[src]++;
		}
	}
	boolean isCyclic()
	{
		int[] arr=new int[this.V]; 
		int[] rank=new int[this.V];
		
		for(int i=0;i<this.V;i++)
		{
			arr[i]=i; //make each vertice its own parent
		}
		
		for(int i=0;i<E;i++)
		{
			int xint=findPathCompression(arr,this.edge[i].src);
			int yint=findPathCompression(arr,this.edge[i].dest);
			
			if(xint==yint)
				return true;
			
			UnionByRank(arr,rank,this.edge[i].src,this.edge[i].dest);
		}
		return false;
	}
	
	public static void main(String args[])
	{
		UnionByRankAndPathCompression graph=new UnionByRankAndPathCompression(4,4);
		
		// add edge 0-1
		graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 2;
        graph.edge[2].dest = 3;
		
		graph.edge[2].src = 3;
        graph.edge[2].dest = 1;
		
		
		if (graph.isCyclic()==true)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
	}
}