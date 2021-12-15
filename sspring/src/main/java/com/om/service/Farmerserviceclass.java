package com.om.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.om.dao.Daointerface;
import com.om.model.Farmer;
import com.om.model.Login;
@Transactional
@Service
public class Farmerserviceclass implements Farmerserviceinterface {
    @Autowired
	Daointerface daointerface;
	public void addFarmerInService(Farmer f1) {
		
		daointerface.addFarmerInDao(f1);
	}
	public List<Farmer> getFarmer() {
		// TODO Auto-generated method stub
	List<Farmer> list=daointerface.getFarmer();
		return list;
	}
	public void deleteFarmer(Integer id) {
		
		
		daointerface.deleteFarmer(id);
		// TODO Auto-generated method stub
		
	}
	public Farmer getFarmerId(Integer obj) {
		// TODO Auto-generated method stub
	return daointerface.getFarmerId(obj);
		
	}
	public boolean updateFarmers(Farmer f) {
		// TODO Auto-generated method stub
		return daointerface.updateFarmers(f);
		
	}
	public Login checkLogin(String username, String password) {
		return daointerface.checkLogin(username,password);
		
	}
	public void addUserInService(Login l) {
		// TODO Auto-generated method stub
		daointerface.addUserInDao(l);
		
	}

}
