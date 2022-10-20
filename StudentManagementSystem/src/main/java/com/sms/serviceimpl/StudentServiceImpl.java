package com.sms.serviceimpl;

import java.util.List;

import com.sms.dao.StudentDao;
import com.sms.daoimpl.StudentDaoImpl;
import com.sms.model.Student;
import com.sms.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public boolean addNewStudent(Student s) {
		// creating an object of DAO Layer
		StudentDao st = new StudentDaoImpl();
		if (st.addStudent(s))
			return true;
		else
			return false;
	}

	// update new student

	@Override
	public void updateNewStudent(Student s) {
		// TODO Auto-generated method stub
		StudentDao st = new StudentDaoImpl();

		st.updateStudent(s);

	}

	// getStudentByID
	@Override
	public Student getNewStudentById(int id) {
		Student ss = null;
		StudentDao st = new StudentDaoImpl();
		ss = st.getStudentById(id);
		return ss;
	}

	// get All the students
	@Override
	public List<Student> getNewAllStudents() {
		List<Student> students = null;
		StudentDao st = new StudentDaoImpl();
		students = st.getAllStudents();

		return students;
	}

	// Remove Delete Student

	@Override
	public void deleteNewStudent(int id) {
		StudentDao st = new StudentDaoImpl();
		st.deleteStudent(id);

	}

}
