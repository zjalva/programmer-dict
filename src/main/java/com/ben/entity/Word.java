package com.ben.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

 
@Entity
@Table(name="word")
public class Word extends BaseEntity {
    
    private static final long serialVersionUID = 5081771805320187003L;
    
    private Category category;
    
    private List<Mean> means;
    private String xiefa;
    private String yinbiao;
    private Integer frequency;
    
    private String shiyi;
    private Dict dict;
    @ManyToOne
    @JoinColumn(name="category_id")
    public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	 
	public String getXiefa() {
		return xiefa;
	}
	public void setXiefa(String xiefa) {
		this.xiefa = xiefa;
	}
	public String getYinbiao() {
		return yinbiao;
	}
	public void setYinbiao(String yinbiao) {
		this.yinbiao = yinbiao;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Mean.class,mappedBy = "word")
    @OrderBy("id")
	public List<Mean> getMeans() {
		return means;
	}
	public void setMeans(List<Mean> means) {
		this.means = means;
	}
	public String getShiyi() {
		return shiyi;
	}
	public void setShiyi(String shiyi) {
		this.shiyi = shiyi;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dict_id")
	public Dict getDict() {
		return dict;
	}
	public void setDict(Dict dict) {
		this.dict = dict;
	}
 
   
}
