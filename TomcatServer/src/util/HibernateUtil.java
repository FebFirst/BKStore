package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static SessionFactory configureSessionFactory(){
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new StandardServiceRegistryBuilder().
	    		applySettings(configuration.getProperties()).build();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
    
//	 private static SessionFactory sessionFactory = 
//	            buildSessionFactory();
//	    private static ServiceRegistry serviceRegistry;
//
//	    private static SessionFactory buildSessionFactory() {
//	        try {
//	            
//	            Configuration configuration = new Configuration();
//	            configuration.configure("/hibernate.cfg.xml");
//	            //Use config file path explicitly 
//	            //configuration.configure("hibernate/hibernate.cfg.xml");
//	            serviceRegistry = new StandardServiceRegistryBuilder()
//	            .applySettings(configuration.getProperties()).build();
//	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//	            return sessionFactory;
//	            
//	        } catch (Throwable ex) {
//	            System.err.println("Initial SessionFactory "
//	                    + "creation failed." + ex);
//	            throw new ExceptionInInitializerError(ex);
//	        }
//	    }
//
//	    public static SessionFactory getSessionFactory() {
//	        return sessionFactory;
//	    }
//
//	    public static void shutdown() {
//	        // Close caches and connection pools
//	        getSessionFactory().close();
//	    }
}