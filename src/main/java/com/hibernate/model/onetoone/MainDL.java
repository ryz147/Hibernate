package com.hibernate.model.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class MainDL {

	public static void main(String[] args) {
		
		System.out.println("Hibernate one to one (Anotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		
		ses.beginTransaction();
		
//		DriversLicense dl= new DriversLicense();
//		
//		dl.setLicenseNum("18MDJUL1988");
//		dl.setAddress("242 beach street");
//		dl.setState("NH");
//		
//		PersonDetails pd = new PersonDetails();
//		pd.setFirstName("Peter");
//		pd.setLastName("Parker");
//		
//		dl.setPd(pd);
//		pd.setDl(dl);
//		
//		ses.save(dl);
		DriversLicense d= ses.get(DriversLicense.class, 1L);
		System.out.println(d.getLicenseNum());
		System.out.println(d.getPd().getFirstName());
		ses.getTransaction().commit();
		ses.close();
		sf.close();
		
		System.out.println("Done");
		
	}

}
