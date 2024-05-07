import java.sql.Connection;

import java.sql.Statement;
import java.util.Scanner;


public class CRUDOperations {

	public static void main(String[] args) {
		
		try {
		Connection connection=DBUtil.getConnection();
		Statement statement=connection.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("please select 1 choice from the following");
		System.out.println("1.add employee \n 2.list all employees 3.remove employee 4.update employee 5.exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1: boolean result=EmployeeOperations.addEmployee(statement);
		if(result) {
			System.out.println("employee added sucessfully");
		}
		break;
		
		case 2: System.out.println("list of employees");
		EmployeeOperations.getEmployees(statement);
		break;
		
		case 3: System.out.println("removal of employee");
		result=EmployeeOperations.removeEmployee(statement);
		if(result) {
			System.out.println("employee deleted sucessfully");
		}
		
		break;
		
		case 4: System.out.println("update an employee");
		result=EmployeeOperations.updateEmployee(statement);
		if(result) {
			System.out.println("Employee updated sucessfully");
		}
		break;
		
		case 5: System.exit(0);
			
		
		}
		
		
	}
	
	catch(Exception e){
		System.out.println("something went wrong");
		System.out.println(e);
	}
	}
	
	
	 
	
}

