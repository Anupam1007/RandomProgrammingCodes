import java.util.*;
class BinaryCode
{
	public static String Decode(String message, int bit)
	{
		String result="";		
		result=result+bit;
		if(message=="3")
			return "NONE";
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
				return result="NONE";
				
		}

		 return result;
	}
	
	public  static String[] decode(String str)
	{
		String arg[]=new String[2];
		
		arg[0]=BinaryCode.Decode(str,0);
		arg[1]=(BinaryCode.Decode(str,1));
		return arg;
	}
//}	
	public static void main(String args[])
	{
		String str="12221112222221112221111111112221111";
		System.out.print(BinaryCode.decode(str)[0] + "\n\n"+ BinaryCode.decode(str)[1] );
		
	}
}