package com.aiitec.demo.model.util;


import javax.swing.*;
import java.awt.*;

/**
 * java代码控制弹出对话框的几种类型
 */
public class AlertUtil {


    /**
     * 显示一个对话框
     *
     * @param parentComponent 展示在哪个父容器里面,一般传null,表示当前网页里面
     * @param message         展示的内容
     * @param title           展示的标题
     * @param messageType     展示的类型(JOptionPane.ERROR_MESSAGE、JOptionPane.INFORMATION_MESSAGE、JOptionPane.WARNING_MESSAGE、 JOptionPane.QUESTION_MESSAGE.....)
     */
    public static void showMessageDialog(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);

    }


    /**
     * 显示一个内部信息对话框(使用默认DEFAULT_OPTION)
     *
     * @param parentComponent 展示在哪个父容器里面,一般传null,表示当前网页里面
     * @param message         展示的内容
     * @param title           展示的标题
     * @param messageType     展示的类型(JOptionPane.ERROR_MESSAGE、JOptionPane.INFORMATION_MESSAGE、JOptionPane.WARNING_MESSAGE、 JOptionPane.QUESTION_MESSAGE.....)
     */
    public static void showInternalMessageDialog(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showInternalMessageDialog(parentComponent, message, title, messageType);

    }

    /**
     * 显示一个内部信息对话框(有三个选项yes/no/cancel)
     *
     * @param parentComponent 展示在哪个父容器里面,一般传null,表示当前网页里面
     * @param message         展示的内容
     * @param title           展示的标题
     * @param optionType      选项( DEFAULT_OPTION,YES_NO_OPTION,YES_NO_CANCEL_OPTION,OK_CANCEL_OPTION)
     * @param messageType     展示的类型(JOptionPane.ERROR_MESSAGE、JOptionPane.INFORMATION_MESSAGE、JOptionPane.WARNING_MESSAGE、 JOptionPane.QUESTION_MESSAGE.....)
     */
    public static void showInternalMessageDialog(Component parentComponent, Object message, String title, int optionType, int messageType) {
        JOptionPane.showInternalMessageDialog(parentComponent, message, title, messageType);

    }

    /**
     * 显示一个信息面板
     *
     * @param parentComponent 展示在哪个父容器里面,一般传null,表示当前网页里面
     * @param message         展示的内容
     * @param title           展示的标题
     * @param messageType     展示的类型(JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.OK_CANCEL_OPTION...)
     */
    public static void showConfirmDialog(Component parentComponent, Object message, String title, int messageType) {
        JOptionPane.showConfirmDialog(parentComponent, message, title, messageType);

    }


    /**
     * 显示一个警告对话框
     *
     * @param parentComponent 展示在哪个父容器里面,一般传null,表示当前网页里面
     * @param message         展示的内容
     * @param title           展示的标题
     * @param optionType      选项( DEFAULT_OPTION,YES_NO_OPTION,YES_NO_CANCEL_OPTION,OK_CANCEL_OPTION)
     * @param messageType     展示的类型(JOptionPane.YES_NO_OPTION,JOptionPane.DEFAULT_OPTION,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.OK_CANCEL_OPTION...)
     * @param icon            展示的图标
     * @param options         自定义选择按钮的文字
     * @param initialValue    默认初始化哪个按钮(如options[0])
     */
    public static void showOptionDialog(Component parentComponent,
                                        Object message, String title, int optionType, int messageType,
                                        Icon icon, Object[] options, Object initialValue) {

        JOptionPane.showOptionDialog(parentComponent, message, title, optionType, messageType, icon, options, initialValue);

    }

    /**
     * 其它样式都用默认的,也可以自己设置
     *
     * @param content 输入对话框的内容
     */
    public static String showInputDialog(String content) {
        return JOptionPane.showInputDialog(content);
    }


    /**
     * 显示一个要求用户选择 String的对话框：
     *
     * @param parentComponent
     * @param message
     * @param title
     * @param messageType
     * @param icon
     * @param selectionValues
     * @param initialSelectionValue
     * @return
     */
    public static Object showInputDialog(Component parentComponent,
                                         Object message, String title, int messageType, Icon icon,
                                         Object[] selectionValues, Object initialSelectionValue) {

        return JOptionPane.showInputDialog(parentComponent, message, title,
                JOptionPane.INFORMATION_MESSAGE, icon,
                selectionValues, initialSelectionValue);
    }

}
