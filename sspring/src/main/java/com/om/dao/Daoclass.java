package com.om.dao;

import java.util.List;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.om.model.Farmer;
import com.om.model.Login;

@Repository
public class Daoclass implements Daointerface {

	@Autowired
	SessionFactory sessionfactory;

	public void addFarmerInDao(Farmer f1) {
		// TODO Auto-generated method stub

		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction tran = session.beginTransaction();
		session.save(f1);
		tran.commit();
	}

	public List<Farmer> getFarmer() {

		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		List<Farmer> list = (List<Farmer>) session.createQuery("From Farmer").list();
		trans.commit();
		return list;

		// TODO Auto-generated method stub
	}

	/*
	 * public boolean deleteFarmer(Integer id) { // TODO Auto-generated method stub
	 * Session session=(Session)sessionfactory.getCurrentSession(); Farmer
	 * f=(Farmer)session.get(Farmer.class, id); session.delete(f);
	 * 
	 * 
	 * return true; }
	 */
	public boolean deleteFarmer(Integer id) {
		// TODO Auto-generated method stub
		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction trans = session.beginTransaction();
		Farmer f = (Farmer) session.get(Farmer.class, id);
		session.delete(f);
		trans.commit();
		return true;

	}

	public Farmer getFarmerId(Integer obj) {
		// TODO Auto-generated method stub
		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction t = session.beginTransaction();

		Farmer obj1 = (Farmer) session.get(Farmer.class, obj);
		t.commit();
		return obj1;

	}

	public boolean updateFarmers(Farmer f) {
		// TODO Auto-generated method stub
		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.saveOrUpdate(f);
		t.commit();
		return true;
	}

	public Login checkLogin(String username, String password) {
		System.out.println("Inside Check Owner Login Dao");
		Criteria criteria;
		Login login = new Login();
		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction t = session.beginTransaction();
		
		criteria = session.createCriteria(Login.class).add(Restrictions.eq("username", username));
		criteria = session.createCriteria(Login.class).add(Restrictions.eq("password", password));
		login = (Login) criteria.setMaxResults(1).uniqueResult();
		t.commit();
		return login;
	}

	public void addUserInDao(Login l) {
		Session session = (Session) sessionfactory.getCurrentSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.save(l);
		t.commit();

	}

}
