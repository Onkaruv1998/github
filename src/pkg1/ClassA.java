package pkg1;

public class ClassA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			throw new velocityException(10,20);
			
		}catch(velocityException e)
		{
			System.out.println(e);
		}
	}

}
