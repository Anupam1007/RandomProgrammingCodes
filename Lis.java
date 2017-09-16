import java.util.*;
class Lis
{
	static int LisLength(int[] arr)
	{
		int size=arr.length;
		int count=1;
		int countPrv=0;
		int data[]=new int[size];
		for(int j=0;j<size;j++)
		{
			if(count>countPrv)
			{
				countPrv=count;
			}
			count=1;
			int last=arr[j];
			for(int i=0;i<size-1;i++)
			{
				
				if(last<arr[i+1])
				{
					count++;
					last=arr[i+1];
				}
				// else
				// {
					// data[i]=count;
				// }
			}
			
		}
		if(count>countPrv)
		{
			countPrv=count;
		}
		return countPrv;
		//System.out.print(Arrays.toString(arr));
	}
	public static void main(String[] args)
	{
		System.out.print(Lis.LisLength(new int[] {3, 10, 2, 1, 20}));
	}
}