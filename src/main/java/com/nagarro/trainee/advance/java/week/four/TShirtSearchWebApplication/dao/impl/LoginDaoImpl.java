package com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.dao.LoginDao;
import com.nagarro.trainee.advance.java.week.four.TShirtSearchWebApplication.model.UserAccount;

@Component
public class LoginDaoImpl implements LoginDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public UserAccount readUserAccount(UserAccount userAccount) {
//	session created
		Session session=this.hibernateTemplate.getSessionFactory().openSession();
		
//		transaction started
		session.beginTransaction();
		
		
		String hqlQuery="FROM UserAccount where username= :inputUsername";
		Query query=session.createQuery(hqlQuery);
		query.setParameter("inputUsername", userAccount.getUsername());
		
//		fetched account details
//		getResultList used instead of uniqueResult as getResultList doesn't throws error
		List<UserAccount> fetchedUserAccountList=query.getResultList();
		
		UserAccount fetchedUserAccount=new UserAccount();
//		fetching 1st result from fetched result list
		if(!CollectionUtils.isEmpty(fetchedUserAccountList))
		{
			fetchedUserAccount.setUsername(fetchedUserAccountList.get(0).getUsername());
			fetchedUserAccount.setPassword(fetchedUserAccountList.get(0).getPassword());
		}
		
//		transaction commited
		session.getTransaction().commit();
		
//		session closed
		session.close();
		
		return fetchedUserAccount;
	}
}
