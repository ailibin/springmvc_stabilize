package com.aiitec.base.model.comm;

import com.aiitec.base.annotation.NoConfound;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoConfound
public abstract class AbstractRespBody {
    /**
     * 状态码
     */
    public int s=1000;
    /**
     * 状态描述，用于记录日志和提示给客户端
     */
    public String desc="";
    /**
     * 系统时间
     */
    @SerializedName("t")
    public String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());

}
