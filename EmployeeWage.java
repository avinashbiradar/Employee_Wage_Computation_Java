import java.util.Random;

public class EmployeeWage {


	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Wage Computation ");
		int ratePerHour = 20;
		int empHour = 0;
		int NUM_WORKING_DAYS = 20;
		
		for (int i = 0; i <= NUM_WORKING_DAYS; i++)
		{
			Random generaterandom = new Random();
			int randomNumber = generaterandom.nextInt(2);
			System.out.println("Random number generated :" + randomNumber);

			switch (randomNumber)
			{
			case 0:
				System.out.println("employee is full-time");
				empHour = 8;
				int salary = (empHour * ratePerHour);
				System.out.println("salary is :" + salary);
				break;
			case 1:
				System.out.println("employee is part-time");
				empHour = 4;
				int salary1 = (empHour * ratePerHour);
				System.out.println("salary is :" + salary1);
				break;
			default:
				System.out.println("employee is absent");
				return;
			}
		}
	}
}


