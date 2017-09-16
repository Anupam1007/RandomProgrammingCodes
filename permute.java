import java.util.*;
class permute
{
	static void swap(char[] arr,int a, int b)
	{
		char temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	static void permuteString(char[] arr,int l)
	{
		int size=arr.length;
		
		if(l==size)
			System.out.println(Arrays.toString(arr));
		for(int i=l;i<size;i++)
		{
			swap(arr,i,l);
			permuteString(arr,l+1);
			swap(arr,i,l);
		}
	}
	public static void main(String args[])
	{
		char arr[]={'a','b','c'};
		permute.permuteString(arr,0);
	}
}