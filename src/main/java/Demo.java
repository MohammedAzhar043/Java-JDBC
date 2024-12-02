import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		int a,rollno,key;
		String name;
		StudentDemo sd = new StudentDemo();
		Student s;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("select the number for your prefered operation....");
		System.out.println(" 1. feteching the student name by using its id.\n 2. to insert a new student intot the student table\n 3. to update a perticualr row.\n 4. to delete a perticular row");
		key = Integer.parseInt(buf.readLine());
		switch (key) {
		case 1:
			System.out.println("enter the roll number");
			rollno = Integer.parseInt(buf.readLine());
		    s=	sd.getStudent(rollno);
			System.out.println(s.sname);
			break;

		case 2 : 	
			System.out.println("enter the roll number");
			rollno =Integer.parseInt(buf.readLine());
			System.out.println("enter the student name");
			name =buf.readLine();
		    a= sd.insertStudent(rollno, name);
			System.out.println(a + " no of row's inserted");
			
			break;
			
		
		case 3 : 	
			System.out.println("enter the roll number");
			rollno =Integer.parseInt(buf.readLine());
			System.out.println("enter the student name");
			name =buf.readLine();
			 a= sd.updateStudent(rollno, name);
			System.out.println(a + " no of row's inserted");
			
			break;	
		case 4:
			System.out.println("enter the roll number");
			rollno = Integer.parseInt(buf.readLine());
			 a= sd.deleteStudent(rollno);
			 System.out.println(a + " no of row's deleted");
			 break;
		default:
			System.out.println("please select a proper number");
			break;
		}


		 
		
		
		
		
	}
}
