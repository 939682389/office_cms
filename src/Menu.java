import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Menu extends JFrame implements ActionListener{
    Login 登录页面;
    Resigter 注册界面;
//    Updatastu 修改学生界面;
//    Delstu 删除学生界面;
    AddVip 增加会员界面;
    DelVip 删除会员界面;
    UpdateVip 修改会员界面;
    AddService 增加服务界面;
//    DelSC 删除选课界面;
    UpdateService 修改服务界面;
    Selsto 学生查询界面;
    JPanel pCenter;
    CardLayout card=null;
    JLabel label=null;
    JMenuBar mb=new JMenuBar();//菜单栏
    JMenu m1=new JMenu("管理员入口");
    JMenuItem login=new JMenuItem("登录");
    JMenuItem resigter=new JMenuItem("注册");
    JMenu m2=new JMenu("人员管理");
    JMenuItem add2=new JMenuItem("add");
    JMenuItem updata2=new JMenuItem("updata");
    JMenuItem delete2=new JMenuItem("delete");
    JMenu m3=new JMenu("服务项目管理");
    JMenuItem add3=new JMenuItem("add3   ");
    JMenuItem updata3=new JMenuItem("updata3   ");
    JMenuItem delete3=new JMenuItem("delete3   ");
    JMenu m4=new JMenu("会员查询管理");
    JMenuItem 学生查询=new JMenuItem("查询信息   ");
    JMenuItem m5=new JMenuItem("系统退出");
    Font t=new Font ("sanerif",Font.PLAIN,12);
    public Menu (){
        this.setTitle("养生足浴店会员管理系统");
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){System.err.println("不能设置外观:   "+e);}
        //组合菜单
        addMenu1();
        addMenu2();
        addMenu3();
        addMenu4();
        addJMenuBar();
        setJMenuBar(mb);
        label=new JLabel("养生足浴店会员管理系统",JLabel.CENTER);
        label.setFont(new Font("宋体",Font.BOLD,30));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(Color.red);
        //点击事件
        login.addActionListener(this);
        resigter.addActionListener(this);

        m5.addActionListener(this);
        add2.addActionListener(this);
        delete2.addActionListener(this);
        updata2.addActionListener(this);
        add3.addActionListener(this);
        delete3.addActionListener(this);
        updata3.addActionListener(this);
        学生查询.addActionListener(this);
        card=new CardLayout();
        pCenter=new JPanel();
        pCenter.setLayout(card);
        登录页面=new Login();
        注册界面=new Resigter();
        增加会员界面=new AddVip();
        删除会员界面=new DelVip();
        修改会员界面=new UpdateVip();
        增加服务界面=new AddService();
//        删除选课界面=new DelSC();
        修改服务界面=new UpdateService();
        学生查询界面=new Selsto();
        pCenter.add("欢迎界面",label);
        pCenter.add("登录页面",登录页面);
        pCenter.add("注册界面",注册界面);
//        pCenter.add("删除学生界面",删除学生界面);
        pCenter.add("增加会员界面",增加会员界面);
        pCenter.add("删除会员界面",删除会员界面);
        pCenter.add("修改会员界面",修改会员界面);
        pCenter.add("增加服务界面",增加服务界面);
//        pCenter.add("删除选课界面",删除选课界面);
        pCenter.add("修改服务界面",修改服务界面);
        pCenter.add("学生查询界面", 学生查询界面);
        add(pCenter,BorderLayout.CENTER);
        validate();
        setVisible(true);
        setBounds(400,150,400,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter(){//关闭程序时的操作
            public void windowClosing(WindowEvent e){System.exit(0);} });
        validate();}
    private void addJMenuBar() {
        mb.add(m1);mb.add(m2);mb.add(m3);mb.add(m4);mb.add(m5);}
    private void addMenu4() {
        m4.add(学生查询);m4.setFont(t);}
    private void addMenu3() {
        m3.add(add3);m3.add(updata3);m3.add(delete3);m3.setFont(t);	}
    private void addMenu2() {//将菜单加入到菜单栏中
        m2.add(add2);m2.add(updata2);m2.add(delete2);m2.setFont(t); }
    private void addMenu1() {
        m1.add(login);m1.add(resigter);m1.setFont(t); }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==m5){System.exit(0);}
        else{if(obj==login){card.show(pCenter,"登录页面");}
        else{if(obj==resigter){ card.show(pCenter,"注册界面");}
        else{if(obj==add2){ card.show(pCenter, "增加会员界面");}
        else{if(obj==delete2){ card.show(pCenter, "删除会员界面");}
        else{if(obj==updata2){ card.show(pCenter, "修改会员界面");}
        else{if(obj==add3){ card.show(pCenter, "增加服务界面");}
        else{if(obj==delete3){ card.show(pCenter, "删除服务界面");}
        else{if(obj==updata3){ card.show(pCenter, "修改服务界面");}
        else{if(obj==学生查询){ card.show(pCenter, "学生查询界面");
        }}}}}}}}}}}
    public static void main(String[] args) {new Menu();}}
