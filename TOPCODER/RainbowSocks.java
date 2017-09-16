//tco17 austin div1
class RainbowSocks
{
	public static double getPairProb(int[] socks, int colorDiff)
	{
		int size=socks.length;
		double total=size*(size-1)/2;
		double probabilityCount=0;
		double ans=0.0d;
		// for(int i=0;i<size;i++)
			// for(int j=0;j<size;j++)
			// {
				// if(i==j)
					// continue;
				// else
				// {
					// if(Math.abs(socks[i] - socks[j]) <= colorDiff)
					// {
						// probabilityCount++;
					// }
					// total++;
				// }
			// }
			
			//or following loop will also do, but set probabilityCount and total to zero initialize for above code
			for(int i=0;i<size;i++)
				for(int j=i+1;j<size;j++)
				{
					if(Math.abs(socks[i] - socks[j]) <= colorDiff)
						probabilityCount++;
				}
					
		return probabilityCount/total;
	}
	public static void main(String args[])
	{
		System.out.println(RainbowSocks.getPairProb(new int[]{44, 14, 24, 31, 30, 32, 46, 23, 27, 2},24));
	}
}