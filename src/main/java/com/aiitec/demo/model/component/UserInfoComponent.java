package com.aiitec.demo.model.component;

import com.aiitec.demo.model.entity.UserEntity;
import com.aiitec.demo.model.repository.UserRepository;
import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInfoComponent {
    private Logger logger = LoggerFactory.getLogger(UserInfoComponent.class);
    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;

    @ReadThroughSingleCache(namespace = "test", expiration = 30000)
    public List<UserEntity> getAllUsers(@ParameterValueKeyProvider int userId){
        // 查询user表中所有记录
        System.out.println("UserInfoComponent println:getAllusers");
        logger.debug("UserInfoComponent debug:getAllusers");
        List<UserEntity> userList = userRepository.findAll();

        return userList;
    }
}
