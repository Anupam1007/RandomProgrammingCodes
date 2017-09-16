import java.util.*;
import java.lang.*;
class VendingMachine
{
	public static int motorUse(String[] prices, String[] purchases)
	{
		
		String[][] input= new String[prices.length][3];
		int row=prices.length;
		int m=prices.length;
		int n=3;
		for(int i=0;i<row;i++)
		{			
			input[i]=prices[i].split(" ");
		}
		int arr1[][]=new int[row][3];
		for(int i=0;i<row;i++)
			for(int j=0;j<3;j++)
				arr1[i][j]=Integer.parseInt(input[i][j]);
			
		
		int lenPurchase=purchases.length;
		String[][] output= new String[lenPurchase][3];
		String[] substrin=new String[lenPurchase];
		for(int i=0;i<lenPurchase;i++)
		{
			substrin[i]=purchases[i].replace(":",",");
			
			output[i]=substrin[i].split(",");
		}
		
		int arr2[][]=new int[lenPurchase][3];
		for(int i=0;i<lenPurchase;i++)
			for(int j=0;j<3;j++)
				arr2[i][j]=Integer.parseInt(output[i][j]);
		
////////////////////////////////////////////////////////	
		int large=arr1[0][0];
		int temp=0,maxcol=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				++temp;
				if(arr1[i][j]>large)
				{
					large=arr1[i][j];
					maxcol=temp-1; //m*i+j;
				}
			}
		}			
		int totalObjectsArr1=arr1.length * arr1[0].length ;
		int counter=0;
		if(maxcol > totalObjectsArr1/2)
			counter+=totalObjectsArr1-maxcol;
		else
			counter+=maxcol;
		
		int arr2Len=arr2.length;
		for(int i=0;i<arr2Len;i++)
		{
			int last=(arr2[i][0]+1)*(arr2[i][1]+1) -1;
			int diff=Math.abs(( last- maxcol));

			
			
			if(Math.abs(diff) > totalObjectsArr1/2)
				counter+=totalObjectsArr1-diff;
			else
				counter+=diff;
			
			//System.out.println(diff+"\t\t"+counter+"\t\t"+last+"\t\t"+arr1[arr2[i][0]][arr2[i][1]]);
			
			arr1[arr2[i][0]][arr2[i][1]] =0;//?
			maxcol=last;
			
			System.out.println(counter);
			//System.out.println(arr1[arr2[i][0]][arr2[i][1]] +"\t\t" +last);
			
			if(i<arr2Len-1 && ((arr2[i+1][2]-arr2[i][2]) > 5))
			{
				temp=0;
				int maxcolTemp=-1;
				large=0;
				for(int k=0;k<m;k++)
				{
					for(int l=0;l<n;l++)
					{
						++temp;
						if(arr1[k][l]>large)
						{
							large=arr1[k][l];
							maxcolTemp=temp-1; //m*i+j;
						}
					}
				}
				diff=Math.abs( maxcolTemp- maxcol);
				
				if(diff > totalObjectsArr1/2)
					counter+=totalObjectsArr1-diff;
				else
					counter+=diff;
				//System.out.println(diff+"\t\t"+maxcolTemp+"\t\t"+maxcol+"\t\t"+counter);
				maxcol=maxcolTemp;
				
				System.out.print("\t\t"+counter+"\n\n");
				
				//System.out.println(diff+"\t\t"+counter);
			}
			
		}
		System.out.println("\n\n"+large+"\t"+totalObjectsArr1 +"\t"+maxcol+ "\t"+ ++counter);
		//System.out.print(arr1[1][1]);
		//System.out.print(Arrays.deepToString(arr2));	
		//System.out.print(Arrays.deepToString(arr1));

		return 0;
	}
	public static void main(String args[])
	{
		
		String[] str1={"100 200 300 400 500 600"};
		String[] str2={"0,2:0", "0,3:5", "0,1:10", "0,4:15"};
		VendingMachine.motorUse(str1,str2);
	}
}