package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="inv_master")
public class Inv_Master implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="inv_no", unique=true, nullable=false)
	private int inv_no;
    
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user",nullable=false)
	private User user;
	
	public int getBillamount() {
		return billamount;
	}
	public void setBillamount(int billamount) {
		this.billamount = billamount;
	}
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Column(name="date", unique=false, nullable=false)
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Date inv_date;
	
	@Column(name="billamount", unique=false, nullable=false)
    private int billamount;
	
    public int getInv_no() {
		return inv_no;
	}
	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getInv_date() {
		return inv_date;
	}
	public void setInv_date(Date inv_date) {
		this.inv_date = inv_date;
	}
}
