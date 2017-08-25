import java.util.*;
class test
{
	int testRecursionCall(int arr[],int i)
	{
		if(i<4)
		{
			arr[i]=testRecursionCall(arr,++i);
			System.out.print(i+" ");
		}
		return i;
	}
	public static void main(String args[])
	{
		// LinkedList<Integer> adj=new LinkedList<Integer>();
		// adj.add(1);
		// adj.add(2);
		// adj.add(3);
		// adj.add(4);
		// adj.add(5);
		// adj.add(6);
		
		// Iterator<Integer> itr=adj.listIterator();
		// // System.out.print(itr.next()+"\t");
		// // System.out.print(itr.next()+"\t");
		// // System.out.print(itr.next()+"\t");
		
		// while(itr.hasNext()){
			// itr.next();
			// System.out.println("this:\t");
		// }
		//---------------------------------
		
		int[] arr={10,20,30,40,50};
		test t=new test();
		t.testRecursionCall(arr,0);
		
		System.out.println(Arrays.toString(arr));
		
		
	}
}