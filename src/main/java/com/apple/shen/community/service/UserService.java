package com.apple.shen.community.service;

import com.apple.shen.community.mapper.UserMapper;
import com.apple.shen.community.model.User;
import com.apple.shen.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        if(user != null) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andAccountIdEqualTo(user.getAccountId());
            List<User> users = userMapper.selectByExample(userExample);
//            User dbUser = userMapper.findByAccountId(user.getAccountId());
            if (users.size() == 0) { //如果用户不存在，则创建用户
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreate());
                userMapper.insert(user);
            } else { //用户存在，则更新用户token信息
                User dbUser = users.get(0);
                User updateUser = new User();
                updateUser.setGmtModified(System.currentTimeMillis());
                updateUser.setToken(user.getToken());
                updateUser.setName(user.getName());
                updateUser.setAvatarUrl(user.getAvatarUrl());
                UserExample example = new UserExample();
                example.createCriteria()
                        .andIdEqualTo(dbUser.getId());
                userMapper.updateByExampleSelective(updateUser, example);
//                userMapper.update(dbUser);
            }
        }
    }
}
