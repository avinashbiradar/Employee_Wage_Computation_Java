import java.util.Random;

public class EmployeeWage {


	public static void main(String[] args) {
		
		System.out.println("Welcome to Employee Wage Computation ");
		int IS_PART_TIME=1;
		int IS_FULL_TIME=2;
		int ratePerHour=20;
		int empHour=0;
		
		Random generaterandom = new Random();
		int randomNumber = generaterandom.nextInt(3);
		System.out.println("Random number generated :" + randomNumber);
		
		if (randomNumber == IS_PART_TIME)
		{
			 empHour=4;	
		}
		else if(randomNumber == IS_FULL_TIME)
		{
			 empHour=8;
		}
		else
		{
			 empHour=0;
		}
		System.out.println("employee hours is:"+empHour);
		int salary=( empHour * ratePerHour);
		System.out.println("employee salary is:"+salary);
	
	}
}


