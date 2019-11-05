package com.apple.shen.community.service;

import com.apple.shen.community.mapper.UserMapper;
import com.apple.shen.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        if(user != null) {
            User dbUser = userMapper.findByAccountId(user.getAccountId());
            if (dbUser == null) { //如果用户不存在，则创建用户
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreate());
                userMapper.insert(user);
            } else { //用户存在，则更新用户token信息
                dbUser.setGmtModified(System.currentTimeMillis());
                dbUser.setToken(user.getToken());
                dbUser.setName(user.getName());
                dbUser.setAvatarUrl(user.getAvatarUrl());
                userMapper.update(dbUser);
            }
        }
    }
}
