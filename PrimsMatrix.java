//done by me, on adjacency matrix,to print edges, another matrix parent[] could be maintained
import java.util.*;
class PrimsMatrix
{
	private int V;
	void primMST(int[][] graph)
	{
		this.V = graph.length;
		int mstSet[] = new int[this.V];
		Arrays.fill(mstSet,-1);
		
		int mark[]=new int[this.V];
		Arrays.fill(mark,100); //filled with infinite initially
		mark[0]=0; // to start with zeroth node

		int verticesIncluded = 0;
		
		int dynamicV=this.V;
		for(int i=0;i<dynamicV;i++)
		{
			int node=min(mark);
			if(!isVertexIncluded(mstSet,node))
			{
				mstSet[i]=node;
				for(int z=0;z<this.V;z++)
				{
					if(graph[i][z]!=0 ) 
					{
							mark[z]=graph[i][z];//update mark[]
					}
				}
			}
			else
			{
				--i;
				mark[node]=100;//to find second lowest no. we are discarding since it is already taken		
				continue;
			}
		}
		System.out.print(Arrays.toString(mstSet));
	}
	int min(int[] mark) 
	{
		int size= mark.length;
		int small=100,index=100;
		for(int i=0;i<size;i++)
		{
			if(mark[i]<small) 
			{
				small=mark[i];
				index=i;
			}	
		}
		return index;
	}
	boolean isVertexIncluded(int[] verticesIncluded,int j)
	{
		for(int i=0;i<verticesIncluded.length;i++)
		{
			if(verticesIncluded[i]==j)
				return true;
		}
		return false;
	}
	public static void main (String[] args)
    {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
       6| 8/    \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        PrimsMatrix t = new PrimsMatrix();
        int graph[][] = new int[][] {
									{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                    };
 
        // Print the solution
        t.primMST(graph);
    }
}