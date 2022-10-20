package com.sms.dao;

//importing packages
import java.util.List;

import com.sms.model.Student;

public interface StudentDao {

	// save a student
	boolean addStudent(Student s);

	// update the student
	void updateStudent(Student ss);

	// get a student by ID
	Student getStudentById(int id);

	// get All the students
	List<Student> getAllStudents();

	// delete student
	void deleteStudent(int id);

}
