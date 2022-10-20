package test.StudentManagementSystem;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sms.model.Student;
import com.sms.service.StudentService;
import com.sms.serviceimpl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
//creating a class Student
public class App {
	// creating logger object

	static Logger log = Logger.getLogger(App.class.getName());

	// main method
	public static void main(String[] args) {
		// creating an object Student Service

		StudentService si = new StudentServiceImpl();

		// try starts
		try (Scanner sc = new Scanner(System.in)) {

			// declaring variables
			int choice, ch;
			// creating student object
			Student se = new Student();
			// creating list of students
			List<Student> ses = null;
			int id;

			// menu driven
			System.out.println("Enter the operation you want to perform:");
			System.out.println("1. Add new student");
			System.out.println("2. Delete a student");
			System.out.println("3. Get details for a particular student");
			System.out.println("4. To Get all the students");
			System.out.println("5. To update the student details");
			System.out.println("6.Exit");

			// entering your choice
			choice = sc.nextInt();

			// switch starts
			switch (choice) {
			case 1:
				// to add a student
				System.out.println("Enter the name");
				se.setName(sc.next());
				System.out.println("Enter the course");
				se.setCourse(sc.next());

				// check whether the student is added
				if (si.addNewStudent(se))
					log.info("---- Student inserted using hibernate ------" + new java.util.Date());
				else
					log.info("===ERROR===" + new java.util.Date());

				// end if ends
				break;
			// case to come out
			case 2:
				// check whether the student is deleted
				System.out.println("Enter the Student Id to be deleted");
				id = sc.nextInt();
				si.deleteNewStudent(id);
				log.info("---- Student deleted using hibernate ------" + new java.util.Date());
				break;

			case 3:
				// find the student
				System.out.println("Enter the Student Id to be displayed");
				id = sc.nextInt();
				se = si.getNewStudentById(id);
				System.out.println("Name:" + se.getName());
				System.out.println("Course:" + se.getCourse());
				break;

			case 4:
				// display all the students
				ses = si.getNewAllStudents();
				for (Student st : ses) {
					System.out.println("Name:" + st.getName());
					System.out.println("Course:" + st.getCourse());
				}
				break;
			case 5:
				// updating the student
				System.out.println("Enter the Student Id to be updated");
				id = sc.nextInt();
				se = si.getNewStudentById(id);
				System.out.println("Name:" + se.getName());
				System.out.println("Course:" + se.getCourse());
				System.out.println("Update name: Press 1");
				System.out.println("Update course: Press 2");
				ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the name");
					se.setName(sc.next());
					si.updateNewStudent(se);
					break;
				case 2:
					System.out.println("Enter the course");
					se.setCourse(sc.next());
					si.updateNewStudent(se);
					break;
				default:
					System.out.println("Wrong input");
				}
				break;

			case 6:
				System.exit(0);

			default:
				System.out.println("Wrong input");

			}
		} catch (Exception e) {
			log.error("Exception Ocuured:" + e + new java.util.Date());
		}

	}
}
