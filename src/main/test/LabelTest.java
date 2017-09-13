import com.aiitec.demo.model.util.Toast;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 测试土司的测试类
 */
public class LabelTest{

        public static void main(String[] args) {
            JFrame frame = new JFrame();

            JPanel panel = new JPanel();
            panel.setAlignmentX(0.5f);
            panel.setAlignmentY(1.0f);
            BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);

            panel.setLayout(boxLayout);

            /**
             * 1-吐司组件的使用
             */
            final Toast toast = new Toast(frame, "北京市没有权限访问", 2000, Toast.error);

            JLabel label = new JLabel("text");
            panel.add(label);
            JButton start = new JButton("start");
            start.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    /**
                     * 2-显示吐司组件
                     */
                    toast.start();


                }
            });
            panel.add(start);

            JButton update = new JButton("update message");
            update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    /**
                     * 3-修改组件消息提示内容
                     */
                    toast.setMessage(Math.random() + "");

                }
            });

            panel.add(update);
            frame.add(panel);
            frame.setSize(960, 660);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        }
}
