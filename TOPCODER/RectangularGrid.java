//SRM 146 DIV 1 #5
class RectangularGrid
{
	public static long countRectangles(int width, int height)
	{
		long t=System.nanoTime();
		
		// long ans= (width+1)*(width)/2 * (height+1)*(height)/2;
		
		// System.out.println(ans);
		// for(int i=width;i>0;i--)
		// {
			// for(int j=height;j>0;j--)
			// {
				// ans-=Math.min(i,j);
			// }
		// }
		
		
		
		
		int ans=0,m,n,i,j;
		for(m=0;m<=width;m++)
		{
			for(n=0;n<=height;n++)
			{
				for(i=m+1;i<=width;i++)
				{
					for(j=n+1;j<=height;j++)
					{
						if((i-m) != (j-n))
						{
							ans++;
						}
					}
				}
			}
		}
		System.out.println(System.nanoTime()-t);
		return ans;
	}

	public static void main(String[] args) 
	{
		System.out.print(RectangularGrid.countRectangles(3,3));
	}
}
		