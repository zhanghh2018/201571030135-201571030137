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
        jlb2=new JLabel("�����β��Գɼ�Ϊ��");
        if(sum>60&&sum<=100){
        	jlb3=new JLabel(s+"�� "+"�����̫����!");
        }
        else{
        	jlb3=new JLabel(s+"�� "+"��Ҫ����Ŭ��Ŷ!");
        }
        jlb1 = new JLabel("Ҫ��Ҫ�ٲ���һ���أ�");
        
        jb1 = new JButton("��ȻҪ");
        jb2 = new JButton("��Ҫ��");
        jb3=new JButton("�鿴���Խ��");

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
        this.setTitle("Сѧ����������");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 300, 220);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "��ȻҪ") {
            new UI();
            this.dispose();
            df2.setVisible(true);
   		    thread1.start();

        } else if (e.getActionCommand() == "��Ҫ��") {
           File f = new File("score.txt");  // ����Ҫɾ�����ļ�λ��
            if(f.exists())
                f.delete();
        	df2.setVisible(false);
        	thread1.stop();
            this.dispose();
        }else if(e.getActionCommand() == "�鿴���Խ��"){
        	PrintChart pc=new PrintChart();
        	//���ļ�
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
