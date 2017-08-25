class Time{
	public static String whatTime(int sec)
	{
		String result="";
		int hour = sec/(60 * 60);
		int min = ((sec/60) - (hour*60));
		int seconds = (sec - (hour*60*60) - min*60) ;
		
		result=result+hour+":"+min+":"+seconds;
		return result;
	}
	public static void main(String args[])
	{
		System.out.println(Time.whatTime(86399));
	}
}