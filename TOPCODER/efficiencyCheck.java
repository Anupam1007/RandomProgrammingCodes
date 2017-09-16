class efficiencyCheck
{
	public static void main(String args[])
	{
		long t1=System.nanoTime();
		long a=11221567;
		long b=999455778;
		long result=0;
		result=a*b;
		
		System.out.println(System.nanoTime()-t1);
		
		long t2=System.nanoTime();
		long count=0;
		for(long i=0;i<21567;i++)
		{
			for(long j=0;j<999;j++)
			{
				count++;
			}
		}
		System.out.println("\n\n"+(System.nanoTime()-t2));
	}
}