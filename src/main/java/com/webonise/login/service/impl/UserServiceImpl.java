package com.webonise.login.service.impl;

import com.webonise.login.dao.UserEntityDao;
import com.webonise.login.model.UserDTO;
import com.webonise.login.model.UserRequest;
import com.webonise.login.model.UserEntity;
import com.webonise.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityDao userEntityDao;

    @Override
    public UserDTO saveUser(UserRequest userRequest) {
        UserEntity userEntity = userEntityDao.save(new UserEntity(userRequest));
        return new UserDTO(userEntity);
    }

    @Override
    public boolean login(String loginId, String password) {
    	System.out.println("loginId="+loginId+" password="+password);
        List<UserEntity> user = userEntityDao.findByLoginIdAndPassword(loginId, password);
        System.out.println("size of user obj="+user.size());
        if(user.size()>0) {
        	  return user != null;
       }
        else {
        	return user==null;
        }
      
    }
}