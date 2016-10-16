package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.service.UserService;
@Controller
public class UserController {
	protected final transient Log log = LogFactory.getLog(UserController.class);
    //注入
	@Autowired
	 private UserService userService;

@RequestMapping("loginView")
		    public String loginView(){
		        return "login";
		   }
@RequestMapping("login")
public  String login( String userName,  String password){
	User user = new User(userName, password);
	String result=userService.loginCheck(user);
	        if(result.equals("ok")){
	            return "success";
	        }
	        else{
	            return "login";
	        }
	    }
@RequestMapping("selectall")
public String selectAll(HttpServletRequest req,HttpServletResponse rep){
	List<User> users=userService.getAllUsers();
    req.setAttribute("userlist", users);
    return "Index";
}
@RequestMapping("addjsp")
public String addjsp(){
    return "add";
}

@RequestMapping("add")
public String add(String userName, String password){
	String result=userService.addUser(userName,password);
	if(result.endsWith("ok"))
	{
		return "redirect:selectall.do";//重定向到另一个方法中
	}
	else return "error";
}
//需要參賽
@RequestMapping("upuser")
public String upuser(String id,String userName,String password,HttpServletRequest req){
	req.setAttribute("id", id);
	req.setAttribute("userName", userName);
	req.setAttribute("password", password);
    return "update";
}
@RequestMapping("update")
public String update(String id,String userName,String password){
	System.out.println(id);
	System.out.println(userName);
	System.out.println(password);
	if(userService.update(id,userName,password))
	return "redirect:selectall.do";
	else return "error";
}
@RequestMapping("del")
public void delete(String id,HttpServletResponse response){
	try{
	userService.deleteUser(id);
	response.getWriter().print("{\"del\":\"true\"}");
	}
	catch(Exception e){
		log.error(e.getMessage());
		e.printStackTrace();
	}
}


}
