package com.aiitec.demo.model.component;


import com.aiitec.demo.model.entity.UserTestEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterComponent {

    public String confirmRegister(UserTestEntity entity){
        return "注册失败";
    }
}
