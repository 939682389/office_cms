import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {
    JTextField 账号,密码;
    JButton 登录;


    public Login(){
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception e){System.err.println("不能设置外观:   "+e);}
        账号=new JTextField(12);
        密码=new JTextField(12);
        登录=new JButton("登录");
        登录.addActionListener(this);
        Box box1=Box.createHorizontalBox();//横放box
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        box1.add(new JLabel("姓名:"));
        box1.add(账号);
        box2.add(new JLabel("密码:"));
        box2.add(密码);
        box4.add(登录);
        Box boxH=Box.createVerticalBox();//竖放box
        boxH.add(box1);
        boxH.add(box2);
        boxH.add(box3);
        boxH.add(box4);
        boxH.add(Box.createVerticalGlue());
        JPanel messPanel=new JPanel();
        messPanel.add(boxH);
        setLayout(new BorderLayout());
        add(messPanel,BorderLayout.CENTER);
        登录.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DBUtil.login(账号.getText(), 密码.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "登录成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "登录失败", "提示", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        validate();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
