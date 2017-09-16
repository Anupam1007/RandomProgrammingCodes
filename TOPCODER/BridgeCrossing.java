//SRM 146 DIV2 6 901 ponts got but 2nd day 2nd attempt
import java.util.*;
class BridgeCrossing
{
	public static int minTime(int[] times)
	{
		int n=times.length;
		int ans=0;
		if (n==1)
			return times[0];//only one element
		Arrays.sort(times);
		int x1=times[0],x2=times[1];
		while(n>3) //if 3 or less left, we will hardcode or improvise in other manner lets see how..
		{
			int y1=times[n-1];
			int y2=times[n-2];
			
			if((2*(x2)+x1+y1)<(2*(x1)+y1+y2))
			{
				ans+=(2*(x2)+x1+y1);
				n-=2;
			}
			else
			{
				ans+=2*x1+y1+y2;
				n-=2;
			}
		}
		if(n==3)
		{
			ans+=times[2]+x1+x2;
		}
		else if(n==2)
			ans= ans+times[1];
		else
			ans=ans+times[0];
		return ans;
	}
	public static void main(String args[])
	{
		System.out.println(minTime(new int[]{ 10}));
	}
}


// { 1, 2, 5, 10 }   //17
// { 1, 2, 3, 4, 5 } //16
// { 100 } //100
// { 1, 2, 3, 50, 99, 100 } //162