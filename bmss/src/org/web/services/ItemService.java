package org.web.services;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.web.model.Items;

public class ItemService extends FactoryService{
	public boolean insert(String itemId,String itemName,String itemPrice,String url,String type)
	{
		SessionFactory sessionFactory;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		int sid = Integer.parseInt(itemId);
		Items i=new Items();
		i.setItemId(sid);
		i.setItemName(itemName);
		i.setItemPrice(itemPrice);
		i.setType(type);
		i.setUrl("upload/"+url);
		session.beginTransaction();
		session.save(i);
		session.getTransaction().commit();
		return true;
		
	}
	public List<Items> reterive()
	{
		String s="s";
		SessionFactory sessionfactory;
		sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		String it="FROM Items where type='"+s+"'";
		Query query=session.createQuery(it);
		List<Items> re= ((org.hibernate.query.Query) query).list();
		return re ;
	}
	public List<Items> reterivecake()
	{
		String c="c";
		SessionFactory sessionfactory;
		sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.openSession();
		String it="FROM Items where type='"+c+"'";
		Query query=session.createQuery(it);
		List<Items> res= ((org.hibernate.query.Query) query).list();
		return res ;
	}
	public List<Items> reteriveItem(int v) {
		Session session = factory.openSession();
		String fir = "FROM Items where item_id = '"+v+"'";
		Query query = session.createQuery(fir);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Items> res = ((org.hibernate.query.Query) query).list();
		return res;
	}
	
	
}


 
