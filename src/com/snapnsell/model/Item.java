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

    @Column(name = "itemPicPath")
	private String itemPicPath;
	
    public Item() {
        super();
    }
    
	public Item(String description, String location, String title, String itemPicPath) {
		this();
		this.description = description;
		this.location = location;
		this.title = title;
		this.itemPicPath = itemPicPath;
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
 }
