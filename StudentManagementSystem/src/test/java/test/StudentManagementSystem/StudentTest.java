package test.StudentManagementSystem;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sms.model.Student;
import com.sms.utility.Helper;

class StudentTest {
	static Session session;

	@BeforeAll
	public static void setup() {
		session = Helper.makeConnection();
	}

	@AfterAll
	public static void tearDown() {

	}

	// positive test case
	@Test
	public void testDelete() {
		Student s = null;
		Transaction tr = session.beginTransaction();
		Integer id = 1;
		s = session.get(Student.class, id);
		session.delete(s);
		tr.commit();

	}

	@AfterEach
	public void closeSession() {

		session.close();
		System.out.println("Session closed\n");
	}
}
