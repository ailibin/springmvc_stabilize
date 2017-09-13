package com.aiitec.demo.model.component;

import com.aiitec.demo.model.entity.UserTestEntity;
import com.aiitec.demo.model.repository.UserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginComponent {

    @Autowired
    UserTestRepository userTestRepository;

    public boolean confirmLoginInfo(UserTestEntity userTestEntity) {
        //查找到所有已经注册好的用户
        List<UserTestEntity> entityList = userTestRepository.findAll();
        System.out.println(entityList.size());
        for (UserTestEntity entity : entityList) {
            //这里根据用户名和密码进行比较
            if (userTestEntity.getUsername().equals(entity.getUsername()) && userTestEntity.getPassword().equals(entity.getPassword())) {
                return true;
            } else {
               continue;
            }
        }
        return false;
    }
}
