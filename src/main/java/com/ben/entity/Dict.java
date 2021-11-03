package com.ben.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

 
@Entity
@Table(name="dict")
public class Dict extends BaseEntity {
    
    private static final long serialVersionUID = 5081771805320187003L;
 
    private String xiefa;
    private String yinbiao;
    private String jieshi;
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
	public String getJieshi() {
		return jieshi;
	}
	public void setJieshi(String jieshi) {
		this.jieshi = jieshi;
	}
    
   
}
