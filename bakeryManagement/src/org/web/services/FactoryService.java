package org.web.services;

import org.hibernate.SessionFactory;
import org.web.model.util.HBFactory;



	public class FactoryService {
		public static  SessionFactory factory;

		public FactoryService() {
			super();
			factory = HBFactory.get();
		}

		public SessionFactory get() {
			return factory;
		}

	}

