
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class EmployeeWageBuilder implements IComputeEmpWageForComp{
	public static final int absent=1;
	public static final int isFullTime=1;
	public static final int isPartTime=2;
	private ArrayList<CompEmployeeWage> empList;
	private Map<String,CompEmployeeWage> empWageMap;
	public EmployeeWageBuilder() {
		empList=new ArrayList<>();
		empWageMap=new HashMap<>();
	}
	@Override
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		CompEmployeeWage empWage = new CompEmployeeWage(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		empList.add(empWage);
		empWageMap.put(company,empWage);
	}

	@Override
	public void computeEmpWage() {
		for(int i=0;i<empList.size();i++) {
			empList.get(i).setTotalEMpWage(this.computeEmpWage(empList.get(i)));
			System.out.println(empList.get(i));
		}	
		
	}
	@Override
	public int getTotalWage(String company) {
		return empWageMap.get(company).totalWage;
	}
	
	private  int computeEmpWage(CompEmployeeWage companyEmpWage) {
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
               totalEmpHours+=empHours;
               totalWorkingDays+=1;
               }
		  return (totalEmpHours*companyEmpWage.empRatePerHour);

	}
	public static void main(String args[]) {
		EmployeeWageBuilder employeeWageBuilder = new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("damrt", 20, 2, 10);
		employeeWageBuilder.addCompanyEmpWage("reliance", 10, 4, 20);
		employeeWageBuilder.addCompanyEmpWage("Flipkart", 30, 6, 30);

		employeeWageBuilder.computeEmpWage();

	}
}