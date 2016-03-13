package quinielasocial.lab.conf;

import java.io.File;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Sesion {
	
	private static final SessionFactory sessionFactory;
		static{
			AnnotationConfiguration cfg2 = new AnnotationConfiguration();
			
			try{
				sessionFactory = cfg2.configure(new File("hibernate.cfg.xml")).buildSessionFactory();
			} catch(Throwable ex){
				ex.printStackTrace();
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static Session openSession() throws HibernateException {
			return sessionFactory.openSession();
		}

}
