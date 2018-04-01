import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
/*
 * @auther:zhangkang
 * @time:2018.03.27
 * function:Continue to test
 */
public class ContinuTest  extends JFrame implements ActionListener{

    JFrame jf;
    JPanel jp;
    JButton jb1,jb2,jb3;
    JLabel jlb1=null,jlb2=null,jlb3=null;
    JPanel jp1,jp2=null;
    DTimeFrame df2=new DTimeFrame();
	
 
	Thread thread1=new Thread(df2);
    public  ContinuTest(int sum)
    {
    	String s=sum+"";
        jf = new JFrame();
        jp = new JPanel();
        jlb2=new JLabel("您本次测试成绩为：");
        if(sum>60&&sum<=100){
        	jlb3=new JLabel(s+"分 "+"你真的太棒啦!");
        }
        else{
        	jlb3=new JLabel(s+"分 "+"还要继续努力哦!");
        }
        jlb1 = new JLabel("要不要再测试一次呢？");
        
        jb1 = new JButton("当然要");
        jb2 = new JButton("不要啦");
        jb3=new JButton("查看测试结果");

        jp1=new JPanel();
        jp2=new JPanel();

        jp1.add(jlb2);
        jp1.add(jlb3);
        jp1.add(jlb1);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp);
        
        jp1.setBounds(40,20,200,80);
        jp2.setBounds(40,100,200,100);
        
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("小学生四则运算");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 300, 220);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "当然要") {
            new UI();
            this.dispose();
            df2.setVisible(true);
   		    thread1.start();

        } else if (e.getActionCommand() == "不要啦") {
           File f = new File("score.txt");  // 输入要删除的文件位置
            if(f.exists())
                f.delete();
        	df2.setVisible(false);
        	thread1.stop();
            this.dispose();
        }else if(e.getActionCommand() == "查看测试结果"){
        	PrintChart pc=new PrintChart();
        	//读文件
        	ReadFile file = new ReadFile("score.txt");  
            String line = null;  
            int[] score=new int[500];
            int titleNum=0;
            while ((line = file.ReadLine()) != null) {  
            	
            	titleNum++;
            	score[titleNum]=Integer.parseInt(line);
            }  
            pc.print(score,titleNum);
            file.close(); 
        }
    }
}
