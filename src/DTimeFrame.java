import java.util.Date;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * @author zhanghh
 * @time 2018.03.28
 */
public class DTimeFrame extends JFrame implements Runnable{
	 private JFrame frame;
	 private JPanel timePanel;
	 private JLabel timeLabel;
	 private JLabel displayArea;
	 private String DEFAULT_TIME_FORMAT = "ss";
	 private int ONE_SECOND = 1000;
 
	 public DTimeFrame(){
		 timePanel = new JPanel();
		 timeLabel = new JLabel("您当前用时： ");
		 displayArea = new JLabel();
	  
		 timePanel.add(timeLabel);
		 timePanel.add(displayArea);
		 this.add(timePanel);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setSize(new Dimension(200,100));
		 this.setBounds(900, 100, 200, 100);
	 }
	 public void run(){
		 int time=1;
		 while(true){
			 	SimpleDateFormat dateFormatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
			 	displayArea.setText(time+"s");
			 	try{
			 		time++;
			 		Thread.sleep(ONE_SECOND); 
			 	}catch(Exception e)
			 	{
			 		displayArea.setText("Error!!!");
			 	}
		 }  
	 } 
}