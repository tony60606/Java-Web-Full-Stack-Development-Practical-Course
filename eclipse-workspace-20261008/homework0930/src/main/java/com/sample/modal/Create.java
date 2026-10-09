package com.sample.modal;

import java.time.LocalDate;

public class Create {

	private LocalDate date ;
	private String title ;
	private String content ;
	private LocalDate createtime ;
	private LocalDate updatetime ;
	private LocalDate deletetime ;
	private String createdby ;
	private String updatedby ;
	private String deletedby ;
	
	public Create(LocalDate date, String title, String content) {
		this.date = date;
		this.title = title;
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatetime() {
		return createtime;
	}

	public void setCreatetime(LocalDate createtime) {
		this.createtime = createtime;
	}

	public LocalDate getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDate updatetime) {
		this.updatetime = updatetime;
	}

	public LocalDate getDeletetime() {
		return deletetime;
	}

	public void setDeletetime(LocalDate deletetime) {
		this.deletetime = deletetime;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getDeletedby() {
		return deletedby;
	}

	public void setDeletedby(String deletedby) {
		this.deletedby = deletedby;
	}
	
	
	
}
