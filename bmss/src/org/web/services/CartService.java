package org.web.services;

import javax.persistence.Query;
import javax.security.auth.login.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.web.model.Customer.*;
import org.web.model.Items;
import org.web.model.Cart;
import org.web.model.util.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.web.model.Items;

public class CartService extends FactoryService {
	public static boolean insert(int v,String user)
	{
		Session session = factory.openSession();
		session.beginTransaction();
		ItemService itemservice = new ItemService();
		List<Items> itm = itemservice.reteriveItem(v);
		System.out.println("ahi");
		for (Items each : itm) {
			Cart cart=new Cart();
			int p=Integer.parseInt(each.getItemPrice());
			cart.setCitemId(v);
			cart.setCitemName(each.getItemName());
			cart.setCurl(each.getUrl());
			cart.setCemail(user);
			cart.setCitemPrice(p);
			session.save(cart);
			session.getTransaction().commit();
			session.close();
		}
		
		return true;
}
	public List<Cart> reterivecart(String v) {
		Session session = factory.openSession();
		String fir = "FROM Cart where cemail = '"+v+"'";
		Query query = session.createQuery(fir);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Cart> res = ((org.hibernate.query.Query) query).list();
		return res;
	}
}
