package org.web.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.model.Customer;
import org.web.model.util.UserReply;


public class LoginService extends FactoryService  {

	public UserReply create(String emailId,  String firstname, String lastname,String password, String phone) {
		Session session = factory.openSession();
		if (session == null)
			System.out.println("1");
		session.beginTransaction();
		
		Customer credential = session.get(Customer.class, emailId);
		UserReply reply = new UserReply();
		if (credential == null) {
			int ph=Integer.parseInt(phone);
			credential = new Customer();
			credential.setEmail(emailId);
			credential.setPassword(password);
			credential.setFirstname(firstname);
			credential.setLastname(lastname);
			credential.setPhone(ph);
			session.save(credential);

			session.getTransaction().commit();
		}
		reply.setCredential(credential);
		session.close();
		return reply;
	}

	public boolean validate(String emailId, String password) {
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Customer customer = session.get(Customer.class, emailId);

		System.out.println(customer.getPassword());
		if (customer != null) {
			if (password.equals(customer.getPassword())) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public boolean modify(String password) {
		String emailId=EmailService.email;
		System.out.println(emailId);
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer credential = session.get(Customer.class, emailId);
		Customer customer = session.get(Customer.class, emailId);
		if (customer != null) {
			credential.setPassword(password);
			session.update(credential);
			session.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
		
	public boolean check(String key)
	{
		String s=RandomService.i;
		if(key.equals(s))
		{
		return true;
		}
		else
		{
			return false;
		}
	}
	public boolean valid(String email)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Customer customer = session.get(Customer.class, email);
		if(customer==null)
			return false;
		else
			return true;
	}
	
}

