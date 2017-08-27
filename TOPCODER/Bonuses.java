//SRM 145
//System.out.println();
import java.util.*;
class Bonuses
{
	public static int[] getDivision(int[] input)
	{
		int size=input.length;
		int sum=0;
		boolean isPointSame=true;
		double sumOfDec=0.0d;
		int ret[]=new int[size];
		for(int i=0;i<size;i++)
		{
			sum=input[i]+sum;
		}
		for(int i=0;i<size;i++)
		{
			double per=(double)((double)input[i]/(double)sum)*100d;
			//ret[i]=(int)per;
			sumOfDec=sumOfDec+(per % 1);
			ret[i]=(int)(per - per%1);
			System.out.println(per+"\t\t"+(per % 1)+"\n\n");
		}
		// System.out.println("\n\n");
		// System.out.println(Arrays.toString(ret));
		// System.out.println("\n\n");
		//System.out.println(Math.ceil(sumOfDec)+"\n\n");
		sumOfDec=Math.ceil(sumOfDec);
		
		//if(isPointSame)
		//{
			// int i=0;
			// while(sumOfDec>0)
			// {
				// ret[i]=ret[i] + 1;
				// i++;
				// sumOfDec--;
			// }
		// }
		//else
		//{
			int[] track=new int[size];
			int max=0,index=-1;
			while(sumOfDec>0)
			{
				for(int i=0;i<size;i++)
				{
					if(ret[i]>max && track[i]!=-1)
					{
						max=ret[i];
						index=i;
					}
				}
				track[index]=-1;
				ret[index]++;
				sumOfDec--;
				max=0;
			}
		//}
		//System.out.println(Arrays.toString(ret));
		
		return ret;
	}
	
	public static void main(String args[])
	{
		int[] arr={485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		System.out.print(Arrays.toString(Bonuses.getDivision(arr)));
	}
}