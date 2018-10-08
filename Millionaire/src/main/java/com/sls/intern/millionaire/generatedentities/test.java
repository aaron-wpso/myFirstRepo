package com.sls.intern.millionaire.generatedentities;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class test {

	public static void main(String[] args)

	{

		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from Question ");


		// You can replace the above to commands with this one

		// Query query = session.createQuery("from Student where studentId = 1 ");

		List list = query.list();

		Question question = (Question) list.get(0);

		System.out.println(question);

	}

}
