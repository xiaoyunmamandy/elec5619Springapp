package au.usyd.elec5619.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import au.usyd.elec5619.DAO.CommentDAO;
import au.usyd.elec5619.domain.Comment;
import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.Subcomment;


@Transactional
@Service(value="commentcreater")
public class SimpleCommentcreater implements Commentcreater{
	@Autowired
	public CommentDAO commentDAO;
	
	public void addcomment(Comment comment) {
		commentDAO.addComment(comment);
	}

	
	public void deletecomment(int commentID) {
		commentDAO.deleteComment(commentID);
		
	}

	
	public List<Comment> getcommentbyuser(int userID) {
		List<Comment> commentlist = commentDAO.getcommentbyuser(userID);
		return commentlist;
	}
	
	public List<Comment> getcommentbyID(int recipeID) {
		List<Comment> comments = commentDAO.getcommentbyID(recipeID);
		return comments;
	}
	
	public void addsub(int commentID, Subcomment sub) {
		Comment c = commentDAO.getcommentbyId(commentID);
		c.addSub(sub);
		commentDAO.updateComment(c);
	}
	
	
}

