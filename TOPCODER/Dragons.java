//SRM 147 DIV1 7	151.72 points/500
import java.util.*;
public class Dragons
{
	public static String snaug(int[] initialFood, int rounds)
	{
		int adj[]={1,0,3,2,5,4};//new int[6];
		double[] input=new double[initialFood.length];
		for(int l=0;l<initialFood.length;l++)
			input[l]=initialFood[l];
		
		for(int z=0;z<rounds;z++)
		{	
			double[] temp=new double[6];
			
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(adj[i] != j && i!=j) //exclude self and adjacent
						temp[j]=temp[j]+input[i]/4;
				}
			}
			input=temp;
			//System.out.println(Arrays.toString(temp)+"\n\n");
		}
		double top=input[2];
		System.out.println(top+"\n\n");
		String ans="";
		double bot=1;
		
		while(top%1 != 0)
		{
			top*=2;
			bot*=2;
		}
		if(bot == 1.0d)
			return ans+(int)top;
		else
			return (ans+(int)top+"/"+(int)bot);
		//return new int[]{0};
	}
	public static void main(String args[])
	{
		System.out.print((snaug(new int[]{0, 0, 4, 0, 0, 0},45)));
	}
}


