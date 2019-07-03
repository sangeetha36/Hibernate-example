package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer") 	//we dont need to specify the table name if we are using the table name same as class name
public class Customer {

	@Id 									//primary key  ---hibernate will automatically understand that id is the primary key
	@GeneratedValue 			//to inform hibernate that this will be a generated value, and not a provided value
	@Column(name="id")
	private int id; 					//we have to put @Id over the column which is primary key
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	private Date dob;
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
