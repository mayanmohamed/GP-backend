package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.CommentDAO;
import com.luv2code.springboot.cruddemo.dao.PostsDAO;
import com.luv2code.springboot.cruddemo.dao.UserDAO;
import com.luv2code.springboot.cruddemo.entity.Comment;
 import com.luv2code.springboot.cruddemo.entity.User;


@RestController
@RequestMapping("/plant")
public class CommentRestAPI {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	PostsDAO postsDAO;
	@Autowired
	CommentDAO commentDAO;
	
	 //WORKSS
	@GetMapping("/comment/{userId}")
	public List<Comment> showUsersPosts(@PathVariable String userId) {
			 User user = userDAO.findById(userId).get();
//		Comment comment =	 commentDAO.findById(1).get();
		//System.out.println(comment.getUserId());
		System.out.println(user.getComments());
			  return user.getComments();
	}

}
