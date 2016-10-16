package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String findUserByUserName(String userName) {
		String sql = String.format(
				"select count(*) from User where userName='%s'", userName);
		int count = jdbcTemplate.queryForInt(sql);
		if (count == 1) {
			return "ok";
		} else {
			return "error";
		}

	}

	public List<User> findAllUsers() {
		String sql="select * from User";
		List<User> users=new ArrayList<User>();
		List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
		for(int i=0;i<list.size();i++){
			User user=new User();
			//不能强制转换long为Integer类型所以调用hashCode
			user.setId((Integer)list.get(i).get("id").hashCode());
			user.setUserName(list.get(i).get("userName").toString());
			user.setPassword(list.get(i).get("password").toString());
			users.add(user);
		}
		return users;

	}

	public String addusers(String userName, String password) {
		 int i = jdbcTemplate.update(  
	                "insert into User(userName,password) values(?,?)",  
	                new Object[] { userName, password });  
		 if(i>0){
			 return "ok";
		 }else{return "error";}

	}

	public boolean upDate(String id, String userName, String password) {
		boolean flag = false;  
        /* 更新实现 */  
        int i = jdbcTemplate  
                .update(  
                        "update User set userName=?,password=? where id=?",  
                        new Object[] {userName,password,id });  
        if (i > 0) {  
            flag = true;  
        }  
        return flag;  

	}

	public void deleteUsers(String id) {
		jdbcTemplate.update("delete from User where id=? ",  
                new Object[] {id});  
	}


}
