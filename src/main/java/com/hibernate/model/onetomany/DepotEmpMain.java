package com.hibernate.model.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class DepotEmpMain {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		
		Department dpt = new Department();
		dpt.setDepartmentName("Finance");
		
		Employee emp = new Employee();
		emp.setFirstName("Mike");
		emp.setLastName("Tyson");
		emp.setDepot(dpt);
		
		Employee emp1= new Employee();
		emp1.setFirstName("Ravi");
		emp1.setLastName("Kanth");
		emp1.setDepot(dpt);
		Employee emp2= new Employee();
		emp2.setFirstName("Matt");
		emp2.setLastName("Tot");
		emp2.setDepot(dpt);
		
		dpt.getEmp().add(emp);
		dpt.getEmp().add(emp1);
		dpt.getEmp().add(emp2);
		ses.saveOrUpdate(dpt);
		ses.getTransaction().commit();
		ses.close();
		sf.close();
		
		
	}

}
