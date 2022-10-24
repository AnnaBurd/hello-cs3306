package com.cs3306.demo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="visitor")
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String message;	
	@CreationTimestamp
	private Timestamp time;
	
	public boolean hasData() {
		
		int emptyFields = 0;
		
		if(this.getName().equals("")) {
			this.setName("anonim");
			emptyFields++;
		}
		
		if(this.getMessage().equals("")) {
			this.setName("no message");
			emptyFields++;
		}
		
		if(emptyFields ==2) {
			return false;
		}
		return true;
	}

}
