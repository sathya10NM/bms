package org.web.services;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.model.Customer;
import org.web.model.util.UserReply;
import org.web.model.Address;

public class AddressService extends FactoryService  {
	public UserReply create(String emailId,  String firstname, String lastname,String address,String phone,String street,String zip,String state,String country) {
		Session session = factory.openSession();
		if (session == null)
			System.out.println("1");
		session.beginTransaction();
		
		Address credentials = session.get(Address.class, emailId);
		UserReply reply = new UserReply();
		if (credentials == null) {
			credentials = new Address();
			credentials.setEmail(emailId);
			credentials.setAddress(address);
			credentials.setCountry(country);
			credentials.setFirstName(firstname);
			credentials.setLastName(lastname);
			credentials.setPhone(phone);
			credentials.setStreet(street);
			credentials.setState(state);
			credentials.setZip(zip);
			session.save(credentials);

			session.getTransaction().commit();
		}
		reply.setCredentials(credentials);
		session.close();
		return reply;
	}
}
