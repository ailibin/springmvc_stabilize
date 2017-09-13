package com.aiitec.demo.model.util;

import javax.swing.*;
import java.awt.*;

public class MyToast extends JDialog {


    private static MyToast toast;

    public MyToast() {
        super();
    }

    public static MyToast getInstance() {
        if (toast == null) {
            toast = new MyToast();
        }
        return toast;
    }

    public void showDialog(String title) {
        toast.setTitle(title);
        toast.setSize(350, 120);
        Container contentPane = toast.getContentPane();
        contentPane.add(new JLabel("", JLabel.CENTER),
                BorderLayout.SOUTH);
        toast.setModal(true);
    }

    public void dismissDialog() {
        toast.dispose();
    }

}
