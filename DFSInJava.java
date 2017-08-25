import java.util.*;
class DFSInJava
{
	private LinkedList<Integer> adj[];
	private int V;
	
	DFSInJava(int V)
	{
		this.V=V;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	void addEdge(int source,int dest)
	{
		adj[source].add(dest);
	}
	
	void BFS(int n)
	{
		boolean[] visited = new boolean[V]; // automatically initialised to zero
		
		BFSUtil(n,visited);
	}
	void BFSUtil(int n,boolean visited[])
	{
		System.out.print(n+"\t");
		visited[n]=true;
		
		Iterator<Integer> itr = adj[n].listIterator();
		while(itr.hasNext())
		{
			int x=itr.next();
			if(!visited[x])
				BFSUtil(x,visited);
		}
	}
	public static void main(String args[])
	{
		DFSInJava g=new DFSInJava(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
	}
}