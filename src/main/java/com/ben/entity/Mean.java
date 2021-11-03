package com.ben.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
@Entity
@Table(name="mean")
public class Mean extends BaseEntity {
    
    private static final long serialVersionUID = 5081771805320187003L;
    
    private Word word;
      
    private String jieshi;
    private String liju;
  
     
    @ManyToOne(cascade = CascadeType.PERSIST,targetEntity = Word.class)
    @JoinColumn(name="word_id")
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public String getJieshi() {
		return jieshi;
	}
	public void setJieshi(String jieshi) {
		this.jieshi = jieshi;
	}
	public String getLiju() {
		return liju;
	}
	public void setLiju(String liju) {
		this.liju = liju;
	}
	

    
}
