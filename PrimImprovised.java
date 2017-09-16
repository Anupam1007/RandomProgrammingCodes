import java.util.*;
class PrimImprovised
{
	int V;
	int min(int[] mark,boolean[] visited)
	{
		int size=mark.length;
		int node=-1;
		int min=100;
		for(int i=0;i<size;i++)
		{
			if(mark[i]<min && !visited[i])
			{
				min=mark[i];
				node=i;
			}
		}
		return node;
	}
	void print(int[] parent, int[][] graph)
	{
		for(int i=1;i<this.V;i++)
		{
			System.out.println("Edge   Weight");
			System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
		}
	}
	void MST(int[][] graph)
	{
		this.V=graph.length;
		int index=-1,node=-1;
		int[] mark = new int[this.V];
		Arrays.fill(mark,100);
		
		int[] parent=new int[this.V];
		Arrays.fill(parent,-1);
		
		boolean[] visited=new boolean[this.V];

		mark[0]=0;
		
		for(int i=0;i<this.V-1;i++)
		{
			node=min(mark,visited);
			visited[node]=true;
			for(int j=0;j<this.V;j++)
			{
				if(graph[node][j] !=0 && !visited[j] && graph[node][j] < mark[j])
				{
					parent[j]=node;
					mark[j]=graph[node][j];
				}
			}
		}
		print(parent,graph);
	}
	
	public static void main(String args[])
	{
		 /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        PrimImprovised t = new PrimImprovised();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        // Print the solution
        t.MST(graph);
	}
}