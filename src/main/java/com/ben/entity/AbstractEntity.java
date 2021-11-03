
package com.ben.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ben.util.TimeSerializer;

/**
 * @Title: AbstractEntity.java
 * Copyright: Copyright (c) 2013 
 * Company:安融科技有限公司
 * 
 * @author michael
 * 2013-3-29 上午9:59:07
 * @version V1.0
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Cloneable {

    private static final long serialVersionUID = -6931127194705248414L;

    private Date createTime;

    private Date updateTime;

    @Column(updatable = false)
    @JsonSerialize(using=TimeSerializer.class)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonSerialize(using=TimeSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public Object clone() {
        try { 
            return super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
