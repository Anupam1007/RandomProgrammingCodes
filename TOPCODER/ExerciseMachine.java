class ExerciseMachine
{
			//System.out.print(hour + "\t" + min+ "\t"+sec);
	public static int getPercentages(String time)
	{

		int hour=0,min=0,sec=0,counter=0;
		
		hour=Integer.valueOf(time.substring(0,2));
		min=Integer.parseInt(time.substring(3,5));
		sec=Integer.parseInt(time.substring(6,8));
		
		double totalSec = hour*60*60 + min*60 + sec;
		for(int i=1;i<totalSec;i++)
		{
			//if(totalSec % i ==0)
			if(((((double)i/totalSec)*100) %1 ==0)) //- (int)((i/totalSec)*100)) == 0.0)
			{
				//System.out.println(((double)i/totalSec)*100 + "\t"+(int)((i/totalSec)*100));
				counter++;
			}
		}
		
		// for(int i=1;i<99;i++)
		// {
			// if((i*totalSec)%100 == 0){ counter++;}//System.out.println(i*totalSec);}
			
		// }
		return counter;
	}
	public static void main(String args[])
	{
		System.out.print(ExerciseMachine.getPercentages("00:14:10"));
		 // double d=23.01;
		 // System.out.print((d)%1);
	}
}

//(i/totalSec)*100 -