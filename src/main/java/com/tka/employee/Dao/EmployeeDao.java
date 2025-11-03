package com.tka.employee.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import tka.employee.entity.Employee;

public class EmployeeDao {
	
		public static SessionFactory factory =null;
		Session session=null;
		
		public SessionFactory getFactory()
		{
			return factory=new Configuration().addAnnotatedClass(Employee.class).configure().buildSessionFactory();
			}
		
		public String saveEmployee(Employee emp)
		{
			session=getFactory().openSession();
			session.save(emp);
			session.beginTransaction().commit();
			return "Employee Added";
		}
		
		public String updateEmployee(Employee emp)
		{
			session=getFactory().openSession();
			session.update(emp);
			session.beginTransaction().commit();
			return "Employee Update";
		}
		
		public String deleteEmployee(Employee emp)
		{
			session=getFactory().openSession();
			session.delete(emp);
			session.beginTransaction().commit();
			return "Employee Delete";
		}
		public List<Employee> viewEmployee()
		{
		session=getFactory().openSession();
		Criteria cri=session.createCriteria(Employee.class);
		List<Employee>lemp=cri.list();
		return lemp;
		}
		
		public Employee getEmployeebyId(int id)
		{
			session=getFactory().openSession();
			Employee emp=session.get(Employee.class, id);
			return emp;
			
		}
		
		public List<Employee> getavgsalaryofemp(){
			  session=getFactory().openSession();
			  Criteria criteria=session.createCriteria(Employee.class);
			  criteria.setProjection(Projections.avg("salary"));
			  List<Employee> ls=criteria.list();
			  return ls;
		  }
		
		public List<Employee> getCount() 
		{
			Criteria criteria=session.createCriteria(Employee.class);
			criteria.setProjection(Projections.count("id"));
			List<Employee>ls=criteria.list();
			return ls;
			}
		
		public List<Employee> getEmployeebylistdesc()
		{
			Criteria criteria=session.createCriteria(Employee.class);
			Order des = Order.desc("salary");   
		    criteria.addOrder(des);             
		    List<Employee> list = criteria.list();

		    for (Employee e : list) {
		        System.out.println(e);
		    }
		    
		    session.close();
			return list;
			    
		}
		
	}


