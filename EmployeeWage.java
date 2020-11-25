import java.util.Random;

public class EmployeeWage {


	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Wage Computation ");

		Random generaterandom = new Random();
		int randomNumber = generaterandom.nextInt(2);
		System.out.println("Random number generated :" + randomNumber);

		if (randomNumber == 1)
		{
			System.out.println("Employee is present");
		}
		else
		{
			System.out.println("Employee is absent");
		}
	}

}
