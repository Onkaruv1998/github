package pkg1;

public class velocityException extends Exception {


		public velocityException(int a,int b)
		{
			System.out.println(a+b);
		}
		
		public String toString()
		{
			return "Exception Activated";
			
		}
	

}
