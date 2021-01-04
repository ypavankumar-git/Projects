package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="user")
public class User implements java.io.Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="uid", unique=true, nullable=true)
	private int uid;
    
	@Column(name="uname", unique=false, nullable=true)
	private String uname;
    
	@Column(name="upass", unique=false, nullable=true)
	private String upass;
	
	@Column(name="location", unique=false, nullable=true)
	private String location;
    
	@Column(name="flag", unique=false, nullable=true, columnDefinition = "integer default 0")
	private int flag;
    
	@Column(name="power", unique=false, nullable=true)
	private String power;
    
	
    public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
