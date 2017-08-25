import java.util.*;
class BinaryCode
{
	public  String[] decode(String message)
	{
		String[] resultArr=new String[2];
		for(int testCase=0;testCase<2;testCase++)
		{		
			String result="";		
			result=result+testCase;
			if(Character.getNumericValue(message.charAt(0)) > 2)
			{
				resultArr[testCase] = "NONE";
				continue;
			}
			int len=message.length();
			for(int i=0;i<len-1;i++)
			{
				int temp=0;
				if(i>0)
					temp = Character.getNumericValue(message.charAt(i)) - ( Character.getNumericValue(result.charAt(i)) + Character.getNumericValue(result.charAt(i-1)));
				else if(i==0)
					temp = Character.getNumericValue(message.charAt(i)) - (Character.getNumericValue(result.charAt(i)) );
				
				if(temp == 0 || temp == 1)
					result=result+temp;
				else
				{
					resultArr[testCase]="NONE";
					break;
				}
					
			}

			 resultArr[testCase]=result;
		}
		return resultArr;
	}	
	public static void main(String args[])
	{
		BinaryCode b=new BinaryCode();
		String str="12221112222221112221111111112221111";
		String arg[]=new String[2];
		arg=b.decode("12221112222221112221111111112221111");
		
		System.out.print(arg[0]);
		
	}
}