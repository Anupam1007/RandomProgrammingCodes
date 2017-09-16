public class Fibonacci
{
  int fib(int n)
  {
    int f[] = new int[n+1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++)
          f[i] = f[i-1] + f[i-2];
    return f[n];
  }
  
  // int fib(int n)
  // {
	  // int a=0;
	  // int b=1;
	  // int fib=0;
	  // for(int i= 2; i <= n; i++)
	  // {
		  // fib=a+b;
		  // a=b;
		  // b=fib;
	  // }
	  
	  // return fib;
  // }
  
  // int fib(int n)
  // {
	// if ( n <= 1 )
		// return n;
	// return fib(n-1) + fib(n-2);
  // }
 
  public static void main(String[] args)
  {
    Fibonacci f = new Fibonacci();
    int n = 29;
	long tim=System.nanoTime();
    System.out.println("Fibonacci number is" + " " + f.fib(n));
	
	System.out.print("\n\n\t\t"+ ((System.nanoTime()-tim)));
  }
 
}
