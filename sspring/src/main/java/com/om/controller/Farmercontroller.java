package com.om.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.model.Farmer;
import com.om.model.Login;
import com.om.service.Farmerserviceinterface;

import net.sf.jasperreports.engine.JRException;
import util.PrintJasperReport;

@Controller
public class Farmercontroller {
	@Autowired
	private Farmerserviceinterface farmerserviceinterface;
	
	@RequestMapping(value="Login")
	public ModelAndView checkLogin(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Login l = farmerserviceinterface.checkLogin(username, password);
		if (l != null) {
			if (l.getUsername().equals(username) && l.getPassword().equals(password)) {
				return new ModelAndView("home");
			} else {
				return new ModelAndView("login");
			}
		                        } 
		else {
			return new ModelAndView("login");
		     }

	    }
	@RequestMapping(value="registerUser")
	public ModelAndView registerUser(@ModelAttribute Login l)
	{
	
		farmerserviceinterface.addUserInService(l);
		ModelAndView model=new ModelAndView("registeruser");
		return model;
		
	}
	@RequestMapping(value="AllFarmerReport")
	public String AllStudentReport(HttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response) throws JRException, NamingException, SQLException, IOException
	{
		System.out.println("opening AllStudentReport");
		
		String filename = "report5";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		PrintJasperReport.printreport(filename, request, response, hm);
		
		return "home";
	}

	@RequestMapping(value = "HomePage")
	public String openHome() {
		System.out.println("opening home page");
		return "home";
	}
	@RequestMapping(value = "LoginPage")
	public String openLo() {
		System.out.println("opening home page");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "addFarmer")
	public ModelAndView addFarmer(@ModelAttribute Farmer f1) {
		farmerserviceinterface.addFarmerInService(f1);
		// ModelAndView model=new ModelAndView();
		return new ModelAndView("home");

	}

	@RequestMapping(value = "aboutPage")
	public ModelAndView getFarmer() {
		List<Farmer> list = farmerserviceinterface.getFarmer();
		System.out.println(list);
		ModelAndView model = new ModelAndView();
		model.addObject("list", list);
		model.setViewName("about");
		return model;
	}

	@RequestMapping(value = "deleteFarmer")
	public ModelAndView deleteFarmer(@ModelAttribute Farmer f) {
		Integer id = f.getId();
		farmerserviceinterface.deleteFarmer(id);
		ModelAndView model = new ModelAndView();
		List<Farmer> list = (List<Farmer>) farmerserviceinterface.getFarmer();
		model.addObject("list", list);
		model.setViewName("about");
		return model;

	}

	@RequestMapping(value = "updateFarmer1", method = RequestMethod.GET)
	public ModelAndView getFarmerbyId(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Farmer fa = (Farmer) farmerserviceinterface.getFarmerId(id);
		System.out.println("controller Data in fa " + fa);
		ModelAndView model = new ModelAndView("updateFarmerPage");
		model.addObject("farmer", fa);
		return model;
	}

	@RequestMapping(value = "updateFarmer", method = RequestMethod.POST)
	public ModelAndView updateFarmer(@ModelAttribute Farmer f) {
		farmerserviceinterface.updateFarmers(f);
		List<Farmer> list = (List<Farmer>) farmerserviceinterface.getFarmer();
		ModelAndView model = new ModelAndView();
		model.addObject("list", list);
		model.setViewName("about");
		return model;

	}
	

}
