package com.ben.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="category")
public class Category extends BaseEntity {
    
    private static final long serialVersionUID = 5081771805320187003L;
    
      
    private String categoryName;


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	 
    
}
