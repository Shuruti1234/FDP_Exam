package com.sms.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sms.dao.StudentDao;
import com.sms.model.Student;
import com.sms.utility.Helper;

import test.StudentManagementSystem.App;

public class StudentDaoImpl implements StudentDao {

	static Logger log = Logger.getLogger(App.class.getName());

	// method to add student
	@Override
	public boolean addStudent(Student s) {
		boolean status = false;
		// calling session to create connection
		try (Session session = Helper.makeConnection()) {
			// starting a transaction
			Transaction tr = session.beginTransaction();
			// saving the Student
			int id = (Integer) session.save(s);
			tr.commit();

			// checking the status
			if (id > 0)
				status = true;
			else
				status = false;

		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);

		}
		// try catch ends

		return status;

	}

	@Override
	public void updateStudent(Student ss) {
		// creating connection
		try (Session session = Helper.makeConnection()) {
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(ss);
			tr.commit();
			log.info("Student updated..." + new java.util.Date());

		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}

	}

	// get student by ID
	@Override
	public Student getStudentById(int id) {

		Student s = null;
		try (Session session = Helper.makeConnection()) {
			Transaction tr = session.beginTransaction();
			s = session.get(Student.class, id);
			tr.commit();

		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);

		}
		return s;
	}

	// get All students

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		List<Student> st = null;
		try (Session session = Helper.makeConnection()) {
			Transaction tr = session.beginTransaction();

			st = session.createQuery("from Student").list();
			tr.commit();

		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
		return st;

	}

	// to delete student
	@Override
	public void deleteStudent(int id) {

		Student s = null;
		try (Session session = Helper.makeConnection()) {
			Transaction tr = session.beginTransaction();
			s = session.get(Student.class, id);
			session.delete(s);
			tr.commit();
			log.info("Student Deleted...." + new java.util.Date());

		} catch (HibernateException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);

		}

	}

}
