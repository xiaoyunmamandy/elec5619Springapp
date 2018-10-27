package au.usyd.elec5619.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import au.usyd.elec5619.domain.Comment;
import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.Subcomment;




public interface Commentcreater extends Serializable{

	public void addcomment(Comment comment);
	public void  deletecomment(int commentID);
	public List<Comment> getcommentbyuser(int userID);
	public List<Comment> getcommentbyID(int recipeID);
	public void addsub(int commentID, Subcomment sub);
	
}