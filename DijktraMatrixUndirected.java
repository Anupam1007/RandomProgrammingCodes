class DijktraMatrixUndirected{
	private int V;
	DijktraMatrixUndirected(int V)
	{
		this.V=V;
	}
	void dijkstra(int[][] graph,int start)
	{
		int[] mstSet=new int[this.V];
		Arrays.fill(mstSet,-1);
		
		int[] mark=new int[this.V];
		Arrays.fill(mark,100);
		
		for(int i=0;i<this.V;i++)
		{
			mstSet[i]=start;//starting vertex
			for(int col=0;col<this.V;col++)
			{
				if(graph[i][col]!=0)
				{
					mark[col]=graph[i][col]; //update mark
				}
			}
			
		}
	}
	
	
	public static void main(String args[])
	{
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        DijktraMatrixUndirected t = new DijktraMatrixUndirected(9);
        t.dijkstra(graph, 0);
	}
}