public class EmployeeWageBuilder implements IComputeWage{
	public static final int absent=1;
	public static final int isFullTime=1;
	public static final int isPartTime=2;
	private int numOfCompany;
	private CompanyEmpWageCal empWageArray[];
	public EmployeeWageBuilder() {
		empWageArray=new CompanyEmpWageCal[5];
	}
	@Override 
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maximumHoursPerMonth) {
		empWageArray[numOfCompany]=new CompanyEmpWageCal(company,empRatePerHour,numOfWorkingDays,maximumHoursPerMonth);
		numOfCompany++;
	}

	@Override
	public void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++) {
			empWageArray[i].setTotalEmpWage(this.computeEmpWage(empWageArray[i]));
			System.out.println(empWageArray[i]);
		}	
		
	}
	private int computeEmpWage(CompanyEmpWageCal companyEmpWage) {
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
               totalWorkingDays += 1;
 }
		 return totalEmpHours * companyEmpWage.empRatePerHour;

	}
	public static void main(String args[]) {
		EmployeeWageBuilder employeeWageBuilder=new EmployeeWageBuilder();
		employeeWageBuilder.addCompanyEmpWage("dmart",20 , 2, 10);
		employeeWageBuilder.addCompanyEmpWage("reliance", 10, 4, 20);
		
		employeeWageBuilder.computeEmpWage();
		
	}}