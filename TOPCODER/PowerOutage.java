import java.util.*;

class PowerOutage
{
	private int V,E;
	Edge edge[];
	
	PowerOutage(int fromJunction[],int toJunction[], int ductlength[])
	{
		int maxSize=fromJunction.length;
		int vertices=0;
		for(int i=0;i<maxSize;i++)
		{
			if(fromJunction[i]>vertices)
				vertices=fromJunction[i];
		}
		for(int i=0;i<maxSize;i++)
		{
			if(toJunction[i]>vertices)
				vertices=toJunction[i];
		}
		
		//System.out.println(vertices);
		this.V=vertices+1;
		this.E=maxSize;
		
		edge=new Edge[E];
		for(int i=0;i<E;i++)
		{
			edge[i]=new Edge();
		}
		
		for(int i=0;i<maxSize;i++)
		{
			this.edge[i].src=fromJunction[i];
			this.edge[i].dest=toJunction[i];
			this.edge[i].weight=ductlength[i];
		}
		
		//System.out.println("the constructer\t"+maxSize+"\n");
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
		while(i<this.E)
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
		int[] fromJunction={0,1,0};
		int[] toJunction={1,2,3};
		int[] ductlength={10,10,10};
		
		PowerOutage graph=new PowerOutage(fromJunction,toJunction,ductlength);
		
		
		graph.MST();
	}
}