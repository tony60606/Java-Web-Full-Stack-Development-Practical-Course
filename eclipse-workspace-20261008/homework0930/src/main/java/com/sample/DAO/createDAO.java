package com.sample.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sample.modal.Create;

public class createDAO {

	private static final List<Create> creates = new ArrayList<>() ;
	
	public static synchronized void add(LocalDate date, String title, String content , String username) {
		Create create = new Create(date,title,content) ;
		
		
		create.setCreatetime(LocalDate.now());
		create.setCreatedby(username);
		
		creates.add(create) ;
		
	}
	
	public static synchronized List<Create> search() {
		return new ArrayList<>(creates);
	}
	 
	public static synchronized boolean update(int index, LocalDate date,String title, String content , String username) {
		if (index < 0 || index >= creates.size()) {
			return false;
		}
		Create create = creates.get(index) ;
		if (create.getDeletetime() != null) {
		    return false;
		}
		if (create.getDate().isBefore(LocalDate.now())) {
		    return false;
		}
		if (date != null && date.isBefore(LocalDate.now())) {
		    return false;
		}
		if (date != null) {
			create.setDate(date);
		}
		if (title != null) {
		    create.setTitle(title);
		}
		if (content != null) {
		    create.setContent(content);
		}
		
		
		create.setUpdatetime(LocalDate.now());
		create.setUpdatedby(username);
		
		return true;
	 }
	 
	
	public static synchronized boolean delete(int index, String username) {
	   if (index < 0 || index >= creates.size()) {
	      return false;
	   }
	  
	   Create create = creates.get(index) ;
	   
	   if (create.getDeletetime() != null) {
	        return false;
	    }
	   
	   create.setTitle("") ;
	   create.setContent("") ;
	   
	   create.setDeletetime(LocalDate.now());
	   create.setDeletedby(username);
	   
	   return true ;
	}
	 
}
