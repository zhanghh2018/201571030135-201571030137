import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/*
 * @author zhangkang
 * @time 2018.03.27
 * function:Display the login interface
 */
public class LoginIn  extends JFrame implements ActionListener{
    JButton jb1,jb2,jb3=null;
    JRadioButton jrb1,jrb2=null;
    JPanel jp1,jp2,jp3=null;
    JTextField jtf=null;
    JLabel jlb1,jlb2=null;
    JPasswordField jpf=null;
    public static void main(String[] args){
        LoginIn ur=new LoginIn();
    }
    public LoginIn(){
        //创建组件
        //创建组件
        jb1=new JButton("登录");
        jb2=new JButton("注册");
        jb3=new JButton("退出");
        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        //label显示
        jlb1=new JLabel("用户名：");
        jlb2=new JLabel("密    码：");
        //文本框输入
        jtf=new JTextField(10);
        jpf=new JPasswordField(10);
       
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("注册登录界面");
        this.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 250, 300, 180);
    }

    public void actionPerformed(ActionEvent e) {

        //监听各个按钮
        if(e.getActionCommand()=="退出"){
            System.exit(0);
        }else if(e.getActionCommand()=="登录"){
            //调用登录方法
            this.login();
        }else if(e.getActionCommand()=="注册"){
            //调用注册方法
            this.Regis();
        }

    }
    //注册方法
    public void Regis(){
        this.dispose();  //关闭当前界
    }

    //登录方法
    public void login(){
        String amdin = this.jtf.getText();
        String  mima = this.jpf.getText();
        if(amdin.equals("admin")&&mima.equals("123456")){
            this.jtf.setText("");
            this.jpf.setText("");
            this.Regis();
            new UI();
        }
        else{
            this.jtf.setText("");
            this.jpf.setText("");
            System.out.println("登陆失败");
        }
    }
}
