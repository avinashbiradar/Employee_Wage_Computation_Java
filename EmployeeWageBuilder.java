
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
public interface IComputeWageOfEmployee {
	interface IComputeEmpWage {
		public void addCompanyEmpWage(String company,int empRatePerHour,int numOfWorkingDays,int maximumHoursPerMonth);
		public void computeEmpWage();
	}
}
public class EmployeeWageBuilder implements IComputeWageOfEmployee{
	public static final int absent=1;
	public static final int isFullTime=1;
	public static final int isPartTime=2;
	private ArrayList<CompanyEmployeeWage> empList;
	private LinkedList<Integer>dailyWage;
	public EmployeeWageBuilder() {
		empList = new ArrayList<>();
		dailyWage = new LinkedList<>();
	}
	
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompanyEmployeeWage empWage=new CompanyEmployeeWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
	}

	
	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEmpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
	HashMap<String,LinkedList> companyDailyWage=new HashMap<>();
	private  int computeEmpWage(CompanyEmployeeWage companyEmpWage) {
		int empHours=0, totalEmpHours=0, totalWorkingDays=0;
		 while(totalEmpHours<=companyEmpWage.maximumHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays){
             int check=(int)(Math.floor(Math.random()*10)%3);
               switch(check){
               case isPartTime:
                       empHours = 4;
                       break;
               case isFullTime:
                       empHours = 8;
                       break;
               default :
                       empHours = 0;
               }
               totalEmpHours += empHours;
               totalWorkingDays +=1;
               dailyWage.add(empHours*companyEmpWage.empRatePerHour);
               
               }
		 companyDailyWage.put(companyEmpWage.company, dailyWage);
		 System.out.println("Daily Wage for the "+companyEmpWage.company+" is :"+dailyWage);
		 dailyWage.clear();
		  return (totalEmpHours*companyEmpWage.empRatePerHour);
		 
	}
	
	public static void main(String args[]) {
		EmployeeWageBuilder employeeWageBuilder=new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("damrt", 20, 2, 10);
		employeeWageBuilder.addCompanyEmpWage("reliance", 10, 4, 20);
		employeeWageBuilder.addCompanyEmpWage("Flipkart", 30, 6, 30);

		
		employeeWageBuilder.computeEmpWage();
	}
	
}
