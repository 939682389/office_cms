import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Map;
import javax.swing.*;

public class Selsto extends JPanel implements ActionListener{
    JTextField 性别,姓名,身份证;
    JButton 查找;
    JTextField 帐号,密码;
    JButton 查找1;
    JTextField 服务名;
    JButton 查找2;
    public Selsto (){
        性别=new JTextField(12);
        姓名=new JTextField(12);
        身份证=new JTextField(12);
        帐号=new JTextField(12);
        密码=new JTextField(12);
        服务名=new JTextField(12);
        查找=new JButton("查找会员信息");
        查找1=new JButton("查找管理员信息");
        查找2=new JButton("查找服务信息");
        Box box1=Box.createHorizontalBox();//横放box
        Box box2=Box.createHorizontalBox();
        Box box4=Box.createHorizontalBox();
        Box box5=Box.createHorizontalBox();
        Box box6=Box.createHorizontalBox();
        Box box7=Box.createHorizontalBox();
        box1.add(new JLabel("性别:",JLabel.CENTER));
        box1.add(性别);
        box1.add(new JLabel("姓名:",JLabel.CENTER));
        box1.add(姓名);
        box1.add(new JLabel("身份证:",JLabel.CENTER));
        box1.add(身份证);
        box2.add(查找);
        box4.add(new JLabel("账号:",JLabel.CENTER));
        box4.add(帐号);
        box4.add(new JLabel("密码:",JLabel.CENTER));
        box4.add(密码);
        box6.add(查找1);
        box5.add(new JLabel("服务名:",JLabel.CENTER));
        box5.add(服务名);
        box7.add(查找2);
        Box boxH1=Box.createVerticalBox();//竖放box
        boxH1.add(box1);
        boxH1.add(box2);
        boxH1.add(Box.createVerticalGlue());
        Box boxH2=Box.createVerticalBox();//竖放box
        boxH2.add(box4);
        boxH2.add(box6);
        boxH2.add(Box.createVerticalGlue());
        Box boxH3=Box.createVerticalBox();//竖放box
        boxH3.add(box5);
        boxH3.add(box7);
        boxH3.add(Box.createVerticalGlue());
        查找.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, String> res = DBUtil.query_vip_by_name_sex_id_card(姓名.getText(), 性别.getText(), 身份证.getText());
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
                        Box bx= Box.createVerticalBox();
                        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
                        bx.add(table.getTableHeader(), BorderLayout.NORTH);
                        // 把 表格内容 添加到容器中心
                        bx.add(table, BorderLayout.CENTER);
                        frame.add(bx);
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

        查找1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, String> res = DBUtil.query_admin_by_username_password(帐号.getText(), 密码.getText());
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
                        Box bx= Box.createVerticalBox();
                        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
                        bx.add(table.getTableHeader(), BorderLayout.NORTH);
                        // 把 表格内容 添加到容器中心
                        bx.add(table, BorderLayout.CENTER);
                        frame.add(bx);
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

        查找2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String, String> res = DBUtil.query_service_by_name(服务名.getText());
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
                        Box bx= Box.createVerticalBox();
                        // 把 表头 添加到容器顶部（使用普通的中间容器添加表格时，表头 和 内容 需要分开添加）
                        bx.add(table.getTableHeader(), BorderLayout.NORTH);
                        // 把 表格内容 添加到容器中心
                        bx.add(table, BorderLayout.CENTER);
                        frame.add(bx);
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
        JPanel messPanel=new JPanel();
        JPanel picPanel=new JPanel();
        JPanel threePanel=new JPanel();
        messPanel.add(boxH1);
        picPanel.add(boxH2);
        threePanel.add(boxH3);
        setLayout(new BorderLayout());
        JSplitPane splitV=new JSplitPane(JSplitPane.VERTICAL_SPLIT,messPanel,picPanel);//分割
        add(splitV,BorderLayout.CENTER);
        JSplitPane splitV1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitV,threePanel);//分割
        add(splitV1,BorderLayout.CENTER);
        validate();}

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
