package com.ben.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ben.dao.BaseHibernateDAO;

 
public abstract class ServiceSupport {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected BaseHibernateDAO baseHibernateDAO;

    @Resource
    public void setBaseHibernateDAO(BaseHibernateDAO baseHibernateDAO) {
        this.baseHibernateDAO = baseHibernateDAO;
    }
}
