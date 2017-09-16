import java.util.*;
class Huffman 
{
	PriorityQueue<HeapElement> PQ;
	class HeapElement 
	{
		char c='\0';
		int f=0;
		char offset='\0';
		public String toString()
		{
			return this.c+"\t"+this.f + "\t"+this.offset+"\n";
		}
	}
	class Tree
	{
		int l=0;
		int r=0;
		int node=0;
	}
	class compareHeapElement implements Comparator<HeapElement>
	{
		public int compare(HeapElement a,HeapElement b)
		{
			//HeapElement a=(HeapElement)a1;
			//HeapElement b=(HeapElement)b1;
			if( a.f > b.f)
				return 1;
			else if(a.f < b.f)
				return -1;
			else
				return 0;
		}
	}
	
	Huffman(char arr1[],int arr2[])
	{
		PQ=new PriorityQueue<HeapElement>(new compareHeapElement());
		LinkedList<Tree> t=new LinkedList<Tree>();
		int size=arr1.length;
		for(int i=0;i<size;i++)
		{
			HeapElement h = new HeapElement();
			h.c=arr1[i];
			h.f=arr2[i];
			h.offset='Y';
			PQ.add(h);
		}
		//System.out.println(PQ);
		while(true)
		{
			HeapElement a1=PQ.poll();
			HeapElement b1=PQ.poll();
			// if(a1.offset == 'N' || b1.offset=='N')
			// {
				// HeapElement c1= new HeapElement();
				// c1.offset='N';
				// c1.f=a1.f+b1.f;
				// PQ.add(a1);
				// PQ.add(b1);
				// PQ.add(c1);
				// break;
			// }
			HeapElement c1= new HeapElement();
			c1.offset='N';
			c1.f=a1.f+b1.f;
			Tree node=
			
			if(a1.offset == 'N' || b1.offset=='N')
			{
				System.out.println(a1+"\t\t"+b1);
				break;
			}
		}
		System.out.println(PQ);
	}
	// void buildSumHeap(char input[],int weight[])
	// {
		// int added[]=new int[input.length];
		// int size = (input.length -1 )/ 2;
		
		// for(int i=0;i<size;i++)
		// {
			// added[it++]=
		// }
	// }
	public static void main(String args[])
	{
		char arr1[]={'a','b','c','d','e','f'};
		int arr2[]={5, 9 ,12 ,13 ,16 ,45};
		Huffman h=new Huffman(arr1,arr2);
	}
}