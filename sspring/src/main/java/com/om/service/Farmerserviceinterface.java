package com.om.service;

import java.util.List;

import com.om.model.Farmer;
import com.om.model.Login;

public interface Farmerserviceinterface {

	void addFarmerInService(Farmer f1);
	List<Farmer> getFarmer();
	void deleteFarmer(Integer id);
	Farmer getFarmerId(Integer obj);
	boolean updateFarmers(Farmer f);
	
	Login checkLogin(String username, String password);
	
	void addUserInService(Login l);
	

	


}
