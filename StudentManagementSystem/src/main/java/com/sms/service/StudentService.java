package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {

	// add a student
	boolean addNewStudent(Student s);

	// update a student

	void updateNewStudent(Student s);

	// getStudentByID
	Student getNewStudentById(int id);

	// get All the students
	List<Student> getNewAllStudents();

	// delete a student
	void deleteNewStudent(int id);

}
