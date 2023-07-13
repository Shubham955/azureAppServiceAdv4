package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.ResetPasswordDao;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;

@Component
public class ResetPasswordDaoImpl implements ResetPasswordDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public int updateUserAccount(UserAccount userAccount) {
//		session created
		Session session=this.hibernateTemplate.getSessionFactory().openSession();
		int recordsUpdated=-1;
//			transaction started
			session.beginTransaction();
			
			String hqlQuery="update UserAccount set password=:inputPassword where username=:inputUsername";
			Query query=session.createQuery(hqlQuery);
			query.setParameter("inputPassword", userAccount.getPassword());
			query.setParameter("inputUsername", userAccount.getUsername());
			
			recordsUpdated=query.executeUpdate();

//			transaction commited
			session.getTransaction().commit();
		
//			session closed
			session.close();
		
		return recordsUpdated;
	}
}
