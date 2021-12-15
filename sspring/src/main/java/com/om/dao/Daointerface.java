package com.om.dao;

import java.util.List;

import com.om.model.Farmer;
import com.om.model.Login;

public interface Daointerface {

	void addFarmerInDao(Farmer f1);
	List<Farmer> getFarmer();
	boolean deleteFarmer(Integer id);
	Farmer getFarmerId(Integer obj);
	boolean updateFarmers(Farmer f);
	
	Login checkLogin(String username, String password);
	void addUserInDao(Login l);



}
