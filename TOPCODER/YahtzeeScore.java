public class YahtzeeScore
{
	public static int maxPoints(int[] toss)
	{
		int size=toss.length;
		int[] vis=new int[toss.length];
		int sumPrev=0;
		int ans=0;
		//Arrays.fill(vis,-1);
		for(int i=0;i<size;i++)
		{
			//vis=i;
			if(sumPrev>ans)
				ans=sumPrev;
			sumPrev=0;
			for(int j=i;j<size;j++)
			{
				if( toss[i]==toss[j])
				{
					sumPrev=sumPrev+toss[j];
				}
			}
			vis[i]=1;
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		System.out.println(maxPoints(new int[]{ 6, 4, 1, 1, 3 }));
	}
}