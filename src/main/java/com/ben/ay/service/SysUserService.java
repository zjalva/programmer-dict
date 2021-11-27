package com.ben.ay.service;

import com.ay.dto.SysUserDTO;
import com.ay.model.SysUser;

import java.util.List;


public interface SysUserService {

    List<SysUser> findAll();

    boolean save(SysUserDTO user);

    SysUser findById(Integer id);

    boolean update(SysUserDTO user);

    boolean updateStatus(SysUserDTO user);
}
