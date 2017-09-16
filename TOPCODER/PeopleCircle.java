//SRM 147 DIV1 7	112.42 points
import java.util.*;
public class PeopleCircle
{
	public static String order(int numMales, int numFemales, int K)
	{
		int size=numFemales+numMales;
		char[] ret=new char[size];
		Arrays.fill(ret,'M');
		int[] removed=new int[size];
		int pos=0;
		for(int i=0;i<numFemales;i++)
		{		
			int counter=0;
			while(counter<K-1)
			{
				if(pos>size-1) pos=pos-size;
				if(removed[pos]==1)
				{
					pos++;
					continue;
				}
				else
				{
					if(pos<=size-2)
						pos++;
					else
						pos=0;
					counter++;
				}
			}
			while(removed[pos]==1)
			{
				pos++;
				if(pos>size-1) pos=pos-size;
			}
			ret[pos]='F';
			removed[pos]=1;
		}
		String ans=new String(ret);
		return ans;
	}
	public static void main(String args[])
	{
		System.out.println(order(25,25,1000));
	}
}