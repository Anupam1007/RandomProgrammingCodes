class PlusSign
{
	public static int draw(String[] pixels)
	{
		int row=pixels.length;
		int col=pixels[0].length();
		int iterateCol=col;
		int offset=0;
		int diff=0;
		
		int x1=100,y1=100,x2=0,y2=0;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<iterateCol;j++)
			{
				if(pixels[i].charAt(j)=='#' )
				{
					if(i<y1)
					{
						y1=i;
						x1=j;
					}
					if(j>x2)
					{
						y2=i;
						x2=j;
					}
				}
				
			}
		}
		
		int left= y1 - 
		
		return 100;
	}
	public static void main(String args[])
	{
		String[] str={".#..",
					 "#.#.",
					 ".#..",	//1
					 "...."};
					 
					 
					 // {"..#....",
					 // ".......",
					 // "......#", //31
					 // ".......",
					 // ".......",
					 // ".......",
					 // "......."}
		System.out.println(PlusSign.draw(str));
	}
}