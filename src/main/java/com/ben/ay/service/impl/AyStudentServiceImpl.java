package com.ben.ay.service.impl;

import com.ay.dao.AyStudentDao;
import com.ay.dao.AyUserAddressDao;
import com.ay.model.AyStudent;
import com.ay.model.AyUserAddress;
import com.ay.service.AyStudentService;
import com.ay.service.AyUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class AyStudentServiceImpl implements AyStudentService {

    @Resource
    private AyStudentDao ayStudentDao;

    public AyStudent findById(Integer id) {
        return ayStudentDao.findById(id);
    }
}
