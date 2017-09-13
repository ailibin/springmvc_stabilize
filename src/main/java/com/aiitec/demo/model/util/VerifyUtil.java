package com.aiitec.demo.model.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具
 * Created by afb on 2017/9/5.
 */

public class VerifyUtil {
    private VerifyUtil() {
    }

    /**
     * 判断手机格式是否正确
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0,1-9])|(15[^4,\\D])|(18[0,1-9])|(14[0,3-9])|(17[0,1-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断email格式是否正确
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 密码强度
     */
    public static String checkPassword(String passwordStr) {
        String str = "^(?:\\d+|[a-zA-Z]+|[!@#$%^&*]+)$"; // 不超过20位的数字组合
        String str1 = "^(?!\\d+$)(?![a-zA-Z]+$)[a-zA-Z\\d]+$"; // 由字母、数字组成，不超过20位
        String str2 = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\\d!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$"; // 由字母不超过20位
        if (passwordStr.matches(str)) {
            return "弱";
        }
        if (passwordStr.matches(str1)) {
            return "中";
        }
        if (passwordStr.matches(str2)) {
            return "强";
        }
        return "弱";
    }

    /**
     * 包含字母
     */
    public static boolean containLetter(String string) {
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(string);
        return m.matches();
    }

    /**
     * 区号+座机号码+分机号码
     */
    public static boolean isFixedPhone(String fixedPhone) {
        String reg = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|" +
                "(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";
        return Pattern.matches(reg, fixedPhone);
    }

    /**
     * 判断是否含有特殊字符
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 邮政编码
     */
    public static boolean isPost(String post) {
        if (post.matches("[0-9]\\d{5}(?!\\d)")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 纯数字
     */
    public static boolean isNumber(String number) {
        String reg = "^\\d+$";
        if (number.matches(reg)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 纯字母
     */
    public static boolean isLetter(String letter) {
        String reg = "[a-zA-Z]+";
        if (letter.matches(reg)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证身份证号码
     *
     * @param idCardNumber
     * @return
     */
    public static boolean isIdCardNumber(String idCardNumber) {
        String reg15 = "^[1-9]\\\\d{7}((0\\\\d)|(1[0-2]))(([0|1|2]\\\\d)|3[0-1])\\\\d{3}$";
        String reg18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
        if (idCardNumber.matches(reg15) || idCardNumber.matches(reg18)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证用户名,只能输入1-30个以字母开头的字串
     * @param userName
     * @return
     */
    public static boolean isTrueName(String userName){
        String reg19=" ^[a-zA-Z]{1,30}$";
        if(userName.matches(reg19)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 验证密码,只能输入6-20个字母、数字、下划线
     * @param password
     * @return
     */
    public static boolean isPasswd(String password){
        String reg20=" ^[A-Za-z0-9_]{6,20}$";
        if(password.matches(reg20)){
            return true;
        }else{
            return false;
        }
    }

}
