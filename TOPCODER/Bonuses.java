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
		int sumOfDec=0;
		//int truncateGain=0;
		int ret[]=new int[size];
		for(int i=0;i<size;i++)
		{
			sum=input[i]+sum;
		}
		for(int i=0;i<size;i++)
		{
			double per=((double)input[i]/sum)*100d;
			ret[i]=(int)per;
			sumOfDec=sumOfDec+ret[i];
		}
		sumOfDec=100-sumOfDec;
		System.out.println(sumOfDec);
		System.out.println(Arrays.toString(ret));
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
		return ret;
	}
	
	public static void main(String args[])
	{
		int[] arr={485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		System.out.print(Arrays.toString(Bonuses.getDivision(arr)));
	}
}

//[8, 6, 5, 2, 8, 5, 5, 3, 1, 5, 4, 4, 6, 3, 4, 4, 1, 8, 1, 6, 3, 8]
//[8, 6, 5, 2, 8, 5, 5, 3, 1, 5, 4, 4, 6, 3, 4, 4, 1, 8, 1, 6, 3, 8]

// import java.util.Comparator;
// import java.util.*;

// public class Bonuses{
  // public  int[] getDivision(int[] points){
		// int totalPoints = 0;    
		// for(int num: points)
	    	// totalPoints += num;
    
		// int[] bonuses = new int[points.length];
		// PriorityQueue<Tuple> maxHeap = new PriorityQueue<Tuple>(points.length, new MyComparator());

   		// int pLeft = 100;
   		// for(int i=0; i < points.length; i++){
     		// bonuses[i] = (points[i] * 100) / totalPoints;
     		// maxHeap.add(new Tuple(bonuses[i],i));
     		// pLeft -= bonuses[i];    		
     	// }   

  		 // /*Start of adding the extra bit of % to the top employees */
   		// while(pLeft > 0){
     		// ++bonuses[maxHeap.poll().val2];
	       	// --pLeft;
       	// }  	
   		// return bonuses;
 	// }
	
	// public class Tuple{
		// public int val1;
		// public int val2;
		// public Tuple(int a, int b){
			// this.val1 = a;
			// this.val2 = b;
		// }
	// }
	
	// public class MyComparator implements Comparator<Tuple>
	// {
    	// public int compare( Tuple x, Tuple y )
	    // {
    	    // if(x.val1 != y.val1)
	    	    // return y.val1 - x.val1;
	    	// return  x.val2 - y.val2;
	    // }
	// }
	
	// public static void main(String args[])
	// {
		// int[] arr={485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296,255, 360, 231, 311, 275,  93, 463, 115, 366, 197, 470};
		// Bonuses b=new Bonuses();
		// System.out.print(Arrays.toString(b.getDivision(arr)));
	// }
// }