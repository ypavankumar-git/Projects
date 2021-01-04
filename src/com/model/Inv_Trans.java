package com.model;

import java.io.Serializable;

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

@Entity
@Table(name="inv_trans")

public class Inv_Trans implements Serializable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="serial_no", unique=false, nullable=false)
	private int serial_no;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="inv_master",nullable=false)
	private Inv_Master inv_master;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="item",nullable=false)
    private Item item;
	
	@Column(name="qty")
	private int qty;
    
    public int getSerial_no() {
		return serial_no; 
	}
	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}
    public Inv_Master getInv_master() {
		return inv_master;
	}
	public void setInv_master(Inv_Master inv_master) {
		this.inv_master = inv_master;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
