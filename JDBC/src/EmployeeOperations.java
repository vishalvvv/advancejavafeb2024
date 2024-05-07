
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeOperations {
	public static boolean addEmployee(Statement statement) {
		boolean result=false;
		Scanner sc = new Scanner(System.in);
		try {
		
		System.out.println("enter eid");
		int eid=sc.nextInt();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter role");
		String role=sc.next();
		System.out.println("enter project");
		String project=sc.next();
		
		String query="insert into Employee values("+eid+",'"+name+"','"+role+"','"+project+"')";
		System.out.println(query);
		statement.execute(query);
		result=true;
		sc.close();
		return result;
		
		
	}
	catch(Exception e) {
		System.out.println(e);
		sc.close();
		return result;
	}
		
}
	
	
	public static void getEmployees(Statement statement) {
		
		try {
			ResultSet rs=statement.executeQuery("select * from employee");
			System.out.println("EID\t\t name \t\t role \t\t project");
			System.out.println("-------------------------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt("eid")+"\t"+rs.getString("name")+"\t"+rs.getString("role")+"\t"+rs.getString("project"));
			}
		}
		
		catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		}
	
	public static boolean removeEmployee(Statement statement) {
		boolean result=false;
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter eid ");
			int eid=sc.nextInt();
			String query="Delete from Employee WHERE eid=" + eid;
			System.out.println(query);
			statement.execute(query);
			result=true;
			sc.close();
			return result;
		}
		catch(Exception e) {
			System.out.println(e);
			sc.close();
			return result;
		}
		
	}
	
	public static boolean updateEmployee(Statement statement) {
		boolean result=false;
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("enter id");
			int eid=sc.nextInt();
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter role");
			String role=sc.next();
			System.out.println("enter project");
			String project=sc.next();
			String query="UPDATE Employee SET name='" + name + "',role='" + role + "',project='" + project + "'WHERE eid=" +eid;
			System.out.println(query);
			statement.execute(query);
			result=true;
			sc.close();
			return result;
		}
		catch(Exception e) {
			System.out.println(e);
			sc.close();
			return result;
		}
	}
	
	

}

