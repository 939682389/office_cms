import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Map;
import javax.swing.*;
public class UpdateVip extends JPanel implements ActionListener{

    String save=null;
    JTextField 卡号1,卡号,姓名;
    JButton 修改,查找;
    public UpdateVip(){
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Exception e){System.err.println("不能设置外观:   "+e);}
        卡号1=new JTextField(12);
        卡号=new JTextField(12);
        姓名=new JTextField(12);
        修改=new JButton("修改");
        查找=new JButton("查找");
        Box box1=Box.createHorizontalBox();//横放box
        Box box2=Box.createHorizontalBox();
        Box box3=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createVerticalBox();
        box1.add(new JLabel("卡号:",JLabel.CENTER));
        box1.add(卡号);
        box2.add(new JLabel("姓名:",JLabel.CENTER));
        box2.add(姓名);
        box3.add(修改);
        box5.add(new JLabel("姓名:",JLabel.CENTER));
        box5.add(卡号1);
        box5.add(查找);
        修改.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    if(DBUtil.update_vip(卡号.getText(), 姓名.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "修改失败", "提示", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        查找.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, String> res = DBUtil.query_vip_by_name(卡号1.getText());
                    if(!res.isEmpty())
                    {
                        System.out.println(res);
                        Object[] keyrow = new Object[res.size()];
                        Object[] valuerow = new Object[res.size()];
                        int i = 0;
                        for (String key : res.keySet()) {
                            keyrow[i] = key;
                            valuerow[i] = res.get(key);
                            i += 1;
                            System.out.println(key);
                        }
                        Object[][] rowData = {valuerow};
                        // 创建一个表格，指定 所有行数据 和 表头

                        JFrame frame=new JFrame("查询结果");
                        frame.setSize(400,200);
                        JTable table = new JTable(rowData, keyrow);
                        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
                        box6.add(table.getTableHeader(), BorderLayout.NORTH);
                        // 把 表格内容 添加到容器中心
                        box6.add(table, BorderLayout.CENTER);
                        frame.add(box6);
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "查询无果", "提示", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        Box boxH=Box.createVerticalBox();//竖放box
        boxH.add(box1);
        boxH.add(box2);
        boxH.add(box3);
        boxH.add(box4);
        boxH.add(Box.createVerticalGlue());
        JPanel picPanel=new JPanel();
        JPanel messPanel=new JPanel();
        messPanel.add(box5);
        picPanel.add(boxH);
        setLayout(new BorderLayout());
        JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//分割
        add(splitV,BorderLayout.CENTER);
        validate();}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
