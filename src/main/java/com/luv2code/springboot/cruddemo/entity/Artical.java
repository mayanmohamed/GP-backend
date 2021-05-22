package com.luv2code.springboot.cruddemo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="artical")
@JsonIdentityInfo(
		   generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Artical {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artical_ID")
	int id ;
	
	@Column(name="content")
	String content;
	
	@Column(name="photo")
	String photo;
	
	@Column(name="create_At")
	LocalDateTime createdAt;
	
	
	@Column(name="title")
	String title;

	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="expert_ID")
	User   expertId;
	
	
	
	public Artical(String content, String photo, LocalDateTime time, String title) {
		this.content = content;
		this.photo = photo;
		this.createdAt = time;
		this.title = title;
	}

//	@JsonBackReference
	@JsonIgnore
	public User getExpertId() {
		return expertId;
	}


	public void setExpertId(User expertId) {
		this.expertId = expertId;
	}


	public Artical() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "Artical [id=" + id + ", content=" + content + ", photo=" + photo + ", createdAt=" + createdAt
				+ ", title=" + title + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
