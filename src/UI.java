
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import javax.swing.*;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
/*
 * @author:zhanghh and zhangkang
 * @time:2018.03.30
 * @function:Display the answer interface and submit the result
 */
public class UI extends JFrame implements ActionListener {
	
	
    JFrame jf;
    JButton jb1,jb2,jb3;
   
    JLabel jlb1=null,jlb2=null;
    JPanel jp1,jp4=null;
    String[] str =new String[21];
    String[] ResultInput = new String[21];
    //题目显示框以及结果输入框
    JTextField a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;
    JTextField b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    //题目显示框以及结果输入框放入JPanel
    JPanel jp21,jp22,jp23,jp24,jp25,jp26,jp27,jp28,jp29,jp20;
    //时间显示线程
    Thread thread1;
    public UI() {
        jf = new JFrame();
        
        jp1 = new JPanel();//开始答题按钮显示
        
        jp4 = new JPanel();//提交按钮以及退出按钮的显示
        //放置题目显示框以及结果输入框
        jp20 = new JPanel();
        jp21 = new JPanel();
        jp22 = new JPanel();
        jp23 = new JPanel();
        jp24 = new JPanel();
        jp25 = new JPanel();
        jp26 = new JPanel();
        jp27 = new JPanel();
        jp28 = new JPanel();
        jp29 = new JPanel();
        //题目显示框以及结果输入框
        a1 = new JTextField(15);
        b1 = new JTextField(2);
        a2 = new JTextField(15);
        b2 = new JTextField(2);
        a3 = new JTextField(15);
        b3 = new JTextField(2);
        a4 = new JTextField(15);
        b4 = new JTextField(2);
        a5 = new JTextField(15);
        b5 = new JTextField(2);
        a6 = new JTextField(15);
        b6 = new JTextField(2);
        a7 = new JTextField(15);
        b7 = new JTextField(2);
        a8 = new JTextField(15);
        b8 = new JTextField(2);
        a9 = new JTextField(15);
        b9 = new JTextField(2);
        a10 = new JTextField(15);
        b10 = new JTextField(2);
        a11 = new JTextField(15);
        b11 = new JTextField(2);
        a12 = new JTextField(15);
        b12 = new JTextField(2);
        a13 = new JTextField(15);
        b13 = new JTextField(2);
        a14 = new JTextField(15);
        b14 = new JTextField(2);
        a15 = new JTextField(15);
        b15 = new JTextField(2);
        a16 = new JTextField(15);
        b16 = new JTextField(2);
        a17 = new JTextField(15);
        b17 = new JTextField(2);
        a18 = new JTextField(15);
        b18 = new JTextField(2);
        a19 = new JTextField(15);
        b19 = new JTextField(2);
        a20 = new JTextField(15);
        b20 = new JTextField(2);
    
        jb1 = new JButton("开始答题");
        jb2 = new JButton("提交");
        jb3= new JButton("退出");
        
        jp1.add(jb1);
        
        jp20.add(a1);
        jp20.add(b1);
        jp20.add(a2);
        jp20.add(b2);
        jp21.add(a3);
        jp21.add(b3);
        jp21.add(a4);
        jp21.add(b4);
        jp22.add(a5);
        jp22.add(b5);
        jp22.add(a6);
        jp22.add(b6);
        jp23.add(a7);
        jp23.add(b7);
        jp23.add(a8);
        jp23.add(b8);
        jp24.add(a9);
        jp24.add(b9);
        jp24.add(a10);
        jp24.add(b10);
        jp25.add(a11);
        jp25.add(b11);
        jp25.add(a12);
        jp25.add(b12);
        jp26.add(a13);
        jp26.add(b13);
        jp26.add(a14);
        jp26.add(b14);
        jp27.add(a15);
        jp27.add(b15);
        jp27.add(a16);
        jp27.add(b16);
        jp28.add(a17);
        jp28.add(b17);
        jp28.add(a18);
        jp28.add(b18);
        jp29.add(a19);
        jp29.add(b19);
        jp29.add(a20);
        jp29.add(b20);

 
        jp4.add(jb2);
        jp4.add(jb3);
        
        this.add(jp1);
        this.add(jp4);
        
        this.add(jp20);
        this.add(jp21);
        this.add(jp22);
        this.add(jp23);
        this.add(jp24);
        this.add(jp25);
        this.add(jp26);
        this.add(jp27);
        this.add(jp28);
        this.add(jp29);
    
       /* jp20.setLayout(new BoxLayout(jp20, BoxLayout.PAGE_AXIS));
        jp21.setLayout(new BoxLayout(jp21, BoxLayout.PAGE_AXIS));
        jp22.setLayout(new BoxLayout(jp22, BoxLayout.PAGE_AXIS));
        jp23.setLayout(new BoxLayout(jp23, BoxLayout.PAGE_AXIS));
        jp24.setLayout(new BoxLayout(jp24, BoxLayout.PAGE_AXIS));
        jp25.setLayout(new BoxLayout(jp25, BoxLayout.PAGE_AXIS));
        jp26.setLayout(new BoxLayout(jp26, BoxLayout.PAGE_AXIS));
        jp27.setLayout(new BoxLayout(jp27, BoxLayout.PAGE_AXIS));
        jp28.setLayout(new BoxLayout(jp28, BoxLayout.PAGE_AXIS));
        jp29.setLayout(new BoxLayout(jp29, BoxLayout.PAGE_AXIS));*/
        
        /*jp21.setLayout(setPreferredSize));
        jp22.setLayout(new GridLayout(3,1));
        jp23.setLayout(new GridLayout(4,1));
        jp24.setLayout(new GridLayout(5,1));
        jp25.setLayout(new GridLayout(6,1));
        jp26.setLayout(new GridLayout(7,1));
        jp27.setLayout(new GridLayout(8,1));
        jp28.setLayout(new GridLayout(9,1));
        jp29.setLayout(new GridLayout(10,1));*/
        
        jp20.setBounds(20,70,450,30);
        jp21.setBounds(20,100,450,30);
        jp22.setBounds(20,130,450,30);
        jp23.setBounds(20,160,450,30);
        jp24.setBounds(20,190,450,30);
        jp25.setBounds(20,220,450,30);
        jp26.setBounds(20,250,450,30);
        jp27.setBounds(20,280,450,30);
        jp28.setBounds(20,310,450,30);
        jp29.setBounds(20,340,450,30);
     
        
        jp1.setBounds(20,380,450,40);
        jp4.setBounds(20,430,450,50);
       
        this.setLocale(null);
       
        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("小学生四则运算");

        this.setBounds(400, 100, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "开始答题") {
        	
        	 DTimeFrame df2=new DTimeFrame();
    		 df2.setVisible(true);
    	  
    		 thread1=new Thread(df2);
    		 thread1.start();
    		 //设置初始答题框为空
             b1.setText("");
             b2.setText("");
             b3.setText("");
             b4.setText("");
             b5.setText("");
             b6.setText("");
             b7.setText("");
             b8.setText("");
             b9.setText("");
             b10.setText("");
             b11.setText("");
             b12.setText("");
             b13.setText("");
             b14.setText("");
             b15.setText("");
             b16.setText("");
             b17.setText("");
             b18.setText("");
             b19.setText("");
             b20.setText("");
     
             FileInputStream fis = null;
		try {
			fis = new FileInputStream("result.txt");
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
   	   // 从文件系统中的某个文件中获取字节  
   		InputStreamReader isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,  
   		BufferedReader br = new BufferedReader(isr);
        String line = null;
        int i=0;
        //产生随机数，进行题目的随机抽取
        int[] rom = new int[21];
        for(i=1;i<=20;i++){
        	Random random = new Random();
        	rom[i] = (int)(Math.random()*20)+25*(i-1);
        	//System.out.println(rom[i]);
        
        }
        i=0;
        int j=1;
        int n=0;
        int flag = 0;
        try {
			while ((line = br.readLine()) != null) { 
			
				for(n=1;n<=20;n++){
					if(i==rom[n]){
						flag=1;
						break;
					}
				}
				if(flag==1){
					
					String[] strl = line.split("=");
					
					str[j] =strl[0].toString()+'=';
					//System.out.println(str[j]);
					ResultInput[j]=strl[1].toString();
					j++;
					flag=0;
				}
			    i++;
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //获取答题框答案
    		a1.setText(str[1]);
    		a2.setText(str[2]);
    		a3.setText(str[3]);
    		a4.setText(str[4]);
    		a5.setText(str[5]);
    		a6.setText(str[6]);
    		a7.setText(str[7]);
    		a8.setText(str[8]);
    		a9.setText(str[9]);
    		a10.setText(str[10]);
    		a11.setText(str[11]);
    		a12.setText(str[12]);
    		a13.setText(str[13]);
    		a14.setText(str[14]);
    		a15.setText(str[15]);
    		a16.setText(str[16]);
    		a17.setText(str[17]);
    		a18.setText(str[18]);
    		a19.setText(str[19]);
    		a20.setText(str[20]);
        //设置出题框为不可编辑
    		a1.setEditable(false);
    		a2.setEditable(false);
    		a3.setEditable(false);
    		a4.setEditable(false);
    		a5.setEditable(false);
    		a6.setEditable(false);
    		a7.setEditable(false);
    		a8.setEditable(false);
    		a9.setEditable(false);
    		a10.setEditable(false);
    		a11.setEditable(false);
    		a12.setEditable(false);
    		a13.setEditable(false);
    		a14.setEditable(false);
    		a15.setEditable(false);
    		a16.setEditable(false);
    		a17.setEditable(false);
    		a18.setEditable(false);
    		a19.setEditable(false);
    		a20.setEditable(false);
  
        }
        else if (e.getActionCommand() == "提交") {
        	
        	ReversePolish reversePolish = new ReversePolish();
        	thread1.stop();
        	int num=0;//正确题目个数
      
        	if(ResultInput[1].equals(b1.getText().toString())){
        	//if(reversePolish.reversePolish(str[1])==(Integer.parseInt(b1.getText().toString())))
        		num++;
        		
        	}
        	if(ResultInput[2].equals(b2.getText().toString())){
        		num++;
        	}
        	if(ResultInput[3].equals(b3.getText().toString())){
        		num++;
        	}
        	if(ResultInput[4].equals(b4.getText().toString())){
        		num++;
        	}
        	if(ResultInput[5].equals(b5.getText().toString())){
        		num++;
        	}
        	if(ResultInput[6].equals(b6.getText().toString())){
        		num++;
        	}
        	if(ResultInput[7].equals(b7.getText().toString())){
        		num++;
        	}
        	if(ResultInput[8].equals(b8.getText().toString())){
        		num++;
        	}
        	if(ResultInput[9].equals(b9.getText().toString())){
        		num++;
        	}
        	if(ResultInput[10].equals(b10.getText().toString())){
        		num++;
        	}
        	if(ResultInput[11].equals(b11.getText().toString())){
        		num++;
        	}
        	if(ResultInput[12].equals(b12.getText().toString())){
        		num++;
        	}
        	if(ResultInput[13].equals(b13.getText().toString())){
        		num++;
        	}
        	if(ResultInput[14].equals(b14.getText().toString())){
        		num++;
        	}
        	if(ResultInput[15].equals(b15.getText().toString())){
        		num++;
        	}
        	if(ResultInput[16].equals(b16.getText().toString())){
        		num++;
        	}
        	if(ResultInput[17].equals(b17.getText().toString())){
        		num++;
        	}
        	if(ResultInput[18].equals(b18.getText().toString())){
        		num++;
        	}
        	if(ResultInput[19].equals(b19.getText().toString())){
        		num++;
        	}
        	if(ResultInput[20].equals(b20.getText().toString())){
        		num++;
        	}
        	//分数计算
        	int score=num*5;
        	
        	//将结果写入文件
        	ContentToTxt contentToTxt = new ContentToTxt();
        	String strFilePath = "score.txt";
        	contentToTxt.contentToTxt(strFilePath,String.valueOf(score));
        	contentToTxt.contentToTxt(strFilePath,String.valueOf("\n"));
        
            
        	//判断是否需要继续，并将结果传入界面
             new  ContinuTest(score);
             this.dispose();
             
        }
        else if(e.getActionCommand() == "退出"){
        	System.exit(0);
        	
           
        }
        
    }
}