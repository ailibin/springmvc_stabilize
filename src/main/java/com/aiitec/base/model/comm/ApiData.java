package com.aiitec.base.model.comm;

import com.aiitec.base.annotation.NoConfound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 响应API头
 * @param <T>
 */
@NoConfound
public class ApiData<T>{
    private static Logger devLogger = LoggerFactory.getLogger("dev");
    public String s="";
    public String n;
    public T q;

    public ApiData(String namespace, T object){
        this.n=namespace;
        this.q = object;
    }
    public ApiData(T object){
        String name = object.getClass().getSimpleName();
        if(name.endsWith("RespBody")){
            name = name.substring(0,name.length()-8);
        }else if(name.endsWith("ReqBody")){
            name = name.substring(0,name.length()-7);
        }else{
            devLogger.warn("响应对象类名不规范："+name);
        }
        this.n = name;
        this.q = object;
    }
}
