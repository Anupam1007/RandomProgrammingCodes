import java.util.*;
class Huffman
{
	class HeapByteBuffer
	{
		private char input[];
		private int weight[];
		HeapByteBuffer(char input[],int weight[])
		{
			this.input=new char[input.length];
			this.weight=new int[weight.length];
			
			this.weight=weight;
			this.input=input;
		}
	}
	Huffman(char arr1[],int arr2[])
	{
		HeapByteBuffer heap = new HeapByteBuffer(arr1,arr2);
		
		System.out.print(Arrays.toString(heap.input));
	}
	
	void buildSumHeap(char input[],int weight[])
	{
		int added[]=new int[input.length];
		int size = (input.length -1 )/ 2;
		
		for(int i=0;i<)
	}
	public static void main(String args[])
	{
		char arr1[]={'a','b','c','d','e','f'};
		int arr2[]={5, 9 ,12 ,13 ,16 ,45};
		Huffman h=new Huffman(arr1,arr2);
	}
}