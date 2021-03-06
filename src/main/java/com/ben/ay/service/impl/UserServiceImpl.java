package com.ben.ay.service.impl;

import com.ay.dao.UserDao;
import com.ay.dto.UserDTO;
import com.ay.model.User;
import com.ay.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public UserDTO find(String id) {
        User user = userDao.find(id);
        return converModel2DTO(user);
    }

    private UserDTO converModel2DTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAccount(user.getAccount());
        userDTO.setName(user.getName());
        return userDTO;
    }
}
