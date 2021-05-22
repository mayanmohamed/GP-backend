package com.luv2code.springboot.cruddemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.luv2code.springboot.cruddemo.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.ArticalsDAO;
//import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.entity.Artical;
import com.luv2code.springboot.cruddemo.entity.User;

@RestController
@RequestMapping("/plant")
public class ExpertRestAPI {

	@Autowired
	UserDAO userDAO;
	
	
	@Autowired
	ArticalsDAO articalsDAO;
	
	@Autowired
	EntityManager entityManager;
	
	//WORKSS
	@GetMapping("/expert")
	public List<User > showAllUsers() {
		//	List<User >  userList = userDAO.findAll();
			List<User> userList= entityManager.createQuery("from User where role =1").getResultList();
			  return userList;
	}
	
	
	
	//WORKSS
	@GetMapping("/expert/articals/{expertId}")
	public List<Artical>  expertArtical(@PathVariable String expertId) {
		
		try {
		User user = userDAO.findById(expertId).get();
		
		
		return user.getArticals();
		}
		catch (Exception e) {
		return new ArrayList<Artical>();
		}
		
	}
	
	//WORKSS
	@GetMapping("/expert/artical/{articalId}")
	public Artical  artical(@PathVariable int articalId) {
		Artical artical= null;
		try {
		  artical = articalsDAO.findById(articalId).get();
		
		
		return artical;
		}
		catch (Exception e) {
		return artical;
		}
		
	}
		
	
	
	
	
	
}
