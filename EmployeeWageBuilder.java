import java.util.ArrayList;

public class EmployeeWageBuilder implements IComputeEmpWage{
	public static final int absent=1;
	public static final int isFullTime=1;
	public static final int isPartTime=2;
	private ArrayList<CompanyEmpWageCalculations> empList;
	public EmployeeWageBuilder() {
		empList=new ArrayList<>();
	}
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompanyEmpWageCalculations empWage=new CompanyEmpWageCalculations(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
	}

	@Override
	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEmpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
	private  int computeEmpWage(CompanyEmpWageCalculations companyEmpWageCalculations) {
		int empHours=0, totalEmpHours=0, totalWorkingDays=0;
		 while(totalEmpHours<=companyEmpWageCalculations.maximumHoursPerMonth && totalWorkingDays<companyEmpWageCalculations.numOfWorkingDays){
             int check=(int)(Math.floor(Math.random()*10)%2);
               switch(check){
               case isPartTime:
                       empHours=4;
                       break;
               case isFullTime:
                       empHours=8;
                       break;
               default :
                       empHours=0;
               }
               totalEmpHours+=empHours;
               totalWorkingDays+=1;
               }
		  return (totalEmpHours * companyEmpWageCalculations.empRatePerHour);

	}
	public static void main(String args[]) {
		EmployeeWageBuilder employeeWageBuilder=new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("damrt", 20, 2, 10);
		employeeWageBuilder.addCompanyEmpWage("reliance", 10, 4, 20);
		employeeWageBuilder.addCompanyEmpWage("Flipkart", 30, 6, 30);

		employeeWageBuilder.computeEmpWage();
	}
}