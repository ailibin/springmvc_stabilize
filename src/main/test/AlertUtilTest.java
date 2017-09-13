import com.aiitec.demo.model.util.AlertUtil;

import javax.swing.*;

public class AlertUtilTest {

    public static void main(String[] args) {
        //1,显示一个错误对话框:
//        AlertUtil.showMessageDialog(null, "这是内容 ", "这是标题 ", JOptionPane.ERROR_MESSAGE);
//        //2,显示一个信息面板，其 options 为 "yes/no ":
        AlertUtil.showConfirmDialog(null, "这是内容", "这是标题", JOptionPane.YES_NO_OPTION);
//        // 3,显示一个警告对话框，其 options 为 OK、CANCEL:
//        Object[] options = {"OK ", "CANCEL "};
//        AlertUtil.showOptionDialog(null, "这是内容 ", "这是标题 ", JOptionPane.DEFAULT_OPTION,
//                JOptionPane.WARNING_MESSAGE, null, options, options[0]);
//        //4,显示一个要求用户键入 String 的对话框：
//        //String inputValue = JOptionPane.showInputDialog( "请输入你的内容:");
//        AlertUtil.showInputDialog( "请输入你的内容:");
//
//        //5,显示一个要求用户选择 String 的对话框：
//        Object[] possibleValues = { "First ", "Second ", "Third " };
//        Object selectedValue = AlertUtil.showInputDialog(null, "这是内容", "这是标题",
//                JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
//
//        //6,这是个简单的警告框:
//        AlertUtil.showMessageDialog(null, "这是内容", "这是标题",JOptionPane.WARNING_MESSAGE);


    }

}
