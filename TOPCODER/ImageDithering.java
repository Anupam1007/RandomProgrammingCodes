import java.util.*;
class ImageDithering
{
	static boolean isFound(String str,char a)
	{
		int size=str.length();
		for(int i=0;i<size;i++)
		{
			if(str.charAt(i)==a)
			{
				return true;
			}
		}
		return false;
	}
	static int count(String str,String[] strArr)
	{
		int sum=0;
		int flag=0;
		int index=0;
		int ifever=0;
		int row=strArr.length;
		int col =strArr[0].length();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(isFound(str,strArr[i].charAt(j)))
				{
					sum++;
					ifever=1;
				}
				
			}
		}
		if(ifever==1)
			return sum;
		else
			return 0;
	}
	public static void main(String args[])
	{
		String str="B";
		String strArr[]={"BBBBBBB",
						 "BBBBBBB",
						 "BBBBBBB"};
		System.out.print(ImageDithering.count(str,strArr));
	}
}