import java.util.*;
import java.io.*;
class BFSinJava{
private int V;
private LinkedList<Integer> adj[];

BFSinJava(int V){
	this.V=V;
	adj=new LinkedList[V];
	for(int i=0;i<V;i++){
		adj[i]=new LinkedList(); //note that we didnt specify LinkedList type eg Integer so it will throw warning, since not checking at compile time
}
}
void addEdge(int source, int dest){
	adj[source].add(dest);
}

void BFS(int n){
	boolean visited[]=new boolean[V];
	LinkedList<Integer> q=new LinkedList<Integer>();
	
	q.add(n);
	visited[n]=true;
	
	while(q.size()!=0)
	{
		n=q.poll();
		System.out.print(n+"\t");
		
		Iterator<Integer> itr= adj[n].listIterator();
		while(itr.hasNext())
		{
			int s=itr.next();
			if(!visited[s])
			{
				visited[s]=true;
				q.add(s);
			}
		}
		
	}
}


public static void main(String args[]){
	BFSinJava g = new BFSinJava(4);
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 3);

	System.out.println("Following is Breadth First Traversal "+
					   "(starting from vertex 2)");

	g.BFS(2);
}
}