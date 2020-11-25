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
		switch(randomNumber) {
		case 1:
				System.out.println("employee is full-time");
		 		empHour=8;
		 		int salary = ( empHour * ratePerHour);
				System.out.println("salary is :"+salary);
				break;
		case 2:
				System.out.println("employee is part-time");
		        empHour=4;
		        int salary1 = ( empHour * ratePerHour);
		        System.out.println("salary is :"+salary1);
		        break;
		default :System.out.println("employee is absent");
		}
	}
}


