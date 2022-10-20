package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fdp_student")

//creating a class
public class Student {

	// creating variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private int s_id;

	@Column(name = "sname", length = 30, nullable = false)
	private String name;

	@Column(name = "scourse", length = 50, nullable = false)
	private String course;

}
//end of class