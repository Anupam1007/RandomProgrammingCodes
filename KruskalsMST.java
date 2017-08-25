import java.util.*;

class KruskalsMST
{
	private int V,E;
	Edge edge[];
	
	KruskalsMST(int V,int E)
	{
		this.V=V;
		this.E=E;
		
		edge=new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]=new Edge();
		}
	}
	class Edge implements Comparable<Edge>
	{
		int src,dest,weight;
		
		public int compareTo(Edge e)
		{
			return this.weight-e.weight ;
		}
	}
	// void addEdge(int e,int src,int dest)
	// {
		// this.edge[e].src=src;
		// this.edge[e].dest=dest;
	// }
	
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
			rank[dest]++;
		}
	}
	// boolean isCyclic(KruskalsMST graph)
	// {
		// int[] arr=new int[this.V]; 
		// int[] rank=new int[this.V];
		
		// for(int i=0;i<this.V;i++)
		// {
			// arr[i]=i; //make each vertice its own parent
		// }
		
		// for(int i=0;i<E;i++)
		// {
			// int xint=findPathCompression(arr,this.edge[i].src);
			// int yint=findPathCompression(arr,this.edge[i].dest);
			
			// if(xint==yint)
				// return true;
			
			// UnionByRank(arr,rank,this.edge[i].src,this.edge[i].dest);
		// }
		// return false;
	// }
	void MST()
	{
		int indexOfResultingMST=0;
		int[] arr=new int[this.V]; 
		int[] rank=new int[this.V];
		Edge[] mstArr=new Edge[this.V];
		for(int i=0;i<this.V;i++)
		{
			arr[i]=i; //make each vertice its own parent
		}
		
		Arrays.sort(this.edge); //edges have been sorted now.
		
		//for(int i=0;i<this.V;i++)
		int i=0;
		while(i<this.V)
		{
			int xint=findPathCompression(arr,this.edge[i].src);
			int yint=findPathCompression(arr,this.edge[i].dest);
			
			if(xint==yint) //if the parent of both are same then dont include in mstList
			{
				i++;
				continue;
			}
			
			UnionByRank(arr,rank,this.edge[i].src,this.edge[i].dest);
			mstArr[indexOfResultingMST] = this.edge[i];
			indexOfResultingMST++;
			i++;
		}
		
		System.out.println("Following are the edges in the constructed MST\n\n");
        for (i = 0; i < indexOfResultingMST; ++i)
            System.out.println(mstArr[i].src+" -- "+mstArr[i].dest+" == "+ mstArr[i].weight);
	}
	public static void main(String args[])
	{
		KruskalsMST graph=new KruskalsMST(4,5);
		

		graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;
 

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;
		
      
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;
		
		
		graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;
		
		graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;
		
		graph.MST();
	}
}