package au.usyd.elec5619.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import au.usyd.elec5619.domain.User;



public interface Usercreater extends Serializable{

	public List<User> getUser();
	public String test();
	public void addUser(User user);
    public void updateUser(User user);
    public User getUserById(int id);
	public void deleteUser(int id);
	public List<User> getallusers();
	public int logincheck(String email, String pwd);
	public User getuserbyemail(String email);
	
}