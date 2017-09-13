package com.aiitec.demo.model.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginApp {
    private static Logger logger = LoggerFactory.getLogger(LoginApp.class);

    public void login(){
        logger.warn("login ok");
    }
}
