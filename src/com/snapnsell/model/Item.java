package com.snapnsell.model;

import java.io.Serializable;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "items")
public class Item extends Model {
	
    @Column(name = "description")
	private String description;
    
    @Column(name = "location")
	private String location;
    
    @Column(name = "title")
	private String title;

    @Column(name = "item_pic_path")
	private String itemPicPath;

    @Column(name = "price")
	private Double price;

    @Column(name = "is_used")
	private boolean used;
    
    public Item() {
    	super();
    }
	
	public Item(String description, String location, String title, String itemPicPath, Double price, boolean used) {
		super();
		this.description = description;
		this.location = location;
		this.title = title;
		this.itemPicPath = itemPicPath;
		this.price = price;
		this.used = used;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getItemPicPath() {
		return itemPicPath;
	}

	public void setItemPicPath(String itemPicPath) {
		this.itemPicPath = itemPicPath;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
 }
