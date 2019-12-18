import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVip extends JPanel implements ActionListener {
    JTextField 姓名,性别,生日,身份证,手机号 ;
    JTextField [] texts = {姓名,性别,生日,身份证,手机号};
    JButton 添加;
    String [] label ={"姓名","性别","生日","身份证","手机号"};

    public AddVip(){
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception e){System.err.println("不能设置外观:   "+e);}
        for(int i =0;i<texts.length;i++){
            texts[i] = new JTextField(12);
        }
        添加=new JButton("注册");
        添加.addActionListener(this);
        Box boxH=Box.createVerticalBox();//竖放box
        for(int i =0;i<texts.length;i++){
            Box box1=Box.createHorizontalBox();//横放box
            box1.add(new JLabel(label[i]));
            box1.add(texts[i]);
            boxH.add(box1);
        }
        Box box=Box.createHorizontalBox();//横放box
        box.add(添加);

        boxH.add(box);
        boxH.add(Box.createVerticalGlue());
        JPanel messPanel=new JPanel();
        messPanel.add(boxH);
        setLayout(new BorderLayout());
        add(messPanel,BorderLayout.CENTER);
        添加.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DBUtil.add_vip(texts[0].getText(), texts[1].getText(),texts[2].getText(),texts[3].getText(),texts[4].getText()))
                        JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "添加失败", "提示", JOptionPane.ERROR_MESSAGE);

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
