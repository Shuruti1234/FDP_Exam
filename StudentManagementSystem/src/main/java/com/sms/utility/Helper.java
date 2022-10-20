package com.sms.utility;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Helper {

	public static Session makeConnection()

	{
		return new Configuration().configure().buildSessionFactory().openSession();
	}

}
