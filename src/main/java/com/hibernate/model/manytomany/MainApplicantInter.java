package com.hibernate.model.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class MainApplicantInter {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		/*Applicants ap= new Applicants();
		ap.setNames("Jason Bucks");
		ap.setSkills("Computer Science");*/
		Applicants ap3 = new Applicants();
		ap3.setNames("Martin");
		ap3.setSkills("Human Resourse");
		
//		Interviewers in = new Interviewers();
//		in.setName("Michel");
//		in.setDepartment("Information Technology");
		
		Interviewers in1 = new Interviewers();
		in1.setName("Atish");
		in1.setDepartment("Management");
	
		in1.getAp().add(ap3);
		//in.getAp().add(ap1);
		
		session.saveOrUpdate(ap3);
		session.saveOrUpdate(in1);
		
		/*Interviewers inter = session.load(Interviewers.class, 1L);
		session.delete(inter);*/
		
		/*Applicants app = session.load(Applicants.class, 1L);
		session.delete(app);*/
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}

}
