package com.aiitec.demo.model.impl;

import com.aiitec.demo.model.service.ControlService;

public class ControlServiceImpl implements ControlService {
    @Override
    public String serviceTest(String keywords) {
        return "serviceTest";
    }
}
