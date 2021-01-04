package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="item_no", unique=true, nullable=false) 
	private int item_no;
	
	@Column(name="item_name", unique=false, nullable=true) 
	private String item_name;
     
	@Column(name="unit", unique=false, nullable=true)
	private String unit;
     
	
	@Column(name="prize", unique=false, nullable=true)
	private int prize;
    
	@Column(name="category", unique=false, nullable=true)
	private String Category;
	
	@Lob
	@Column(name="image",unique=false, nullable=true)
     private String image;
	
	
     
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}
	
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
     
}
