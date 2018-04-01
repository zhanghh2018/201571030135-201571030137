import java.awt.Font;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartFrame;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis3D;  
import org.jfree.chart.axis.NumberAxis3D;  
import org.jfree.chart.axis.NumberTickUnit;  
import org.jfree.chart.labels.ItemLabelAnchor;  
import org.jfree.chart.labels.ItemLabelPosition;  
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer3D;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.ui.TextAnchor;  
/**
 *
 * @author zhanghh 
 * @time:2018.03.29
 * @function:Display histogram
 *
 */
public class  PrintChart {  
	public static void print(int[] Score,int  SubmissionsNum){
      
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        //�������  
		for(int i=1;i<=SubmissionsNum;i++){
			
			dataset.addValue(Score[i],"����"+i, "��"+i+"��"); 
			 
		}
		
        JFreeChart chart = ChartFactory.createBarChart3D("����ͳ��ͼ", //�����������  
                          								"���Դ���", //X��ı�ǩ  
                                                        "���Է���(����)", //Y��ı�ǩ  
                                                        dataset, //ͼ����ʾ�����ݼ���  
                                                        PlotOrientation.VERTICAL,//ͼ�����ʾ��ʽ��ˮƽ���ߴ�ֱ��   
                                                        true, //�Ƿ���ʾ�ӱ���  
                                                        true, //�Ƿ�������ʾ�ı�ǩ  
                                                        true);//�Ƿ�����url����  
        
        //����ͼ���ϵ�����  
        //���������������  
        chart.getTitle().setFont(new Font("����",Font.BOLD,18));  
        //�����ӱ�������  
        chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));  
        //��ȡͼ���������  
        CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();  
        //��ȡX��Ķ���  
        CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();  
        //��ȡY��Ķ���  
        NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();  
        //����X���ϵ�����  
        categoryAxis3D.setTickLabelFont(new Font("����",Font.BOLD,15));  
        //����X���������  
        categoryAxis3D.setLabelFont(new Font("����",Font.BOLD,15));  
        //����Y���ϵ�����  
        numberAxis3D.setTickLabelFont(new Font("����",Font.BOLD,15));  
        //����Y���������  
        numberAxis3D.setLabelFont(new Font("����",Font.BOLD,15));  
        //����Y������ʾ�Ŀ̶ȣ���1��Ϊ1��  
        numberAxis3D.setAutoTickUnitSelection(false);  
        NumberTickUnit unit = new NumberTickUnit(100);  
        numberAxis3D.setTickUnit(unit);  
        //��ȡ��ͼ�������  
        BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();  
        //��������ͼ�Ŀ��  
        barRenderer3D.setMaximumBarWidth(0.07);  
        //��ͼ������ʾ����  
        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        barRenderer3D.setBaseItemLabelsVisible(true);  
        //����  
        barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1,TextAnchor.CENTER));  
        barRenderer3D.setBaseItemLabelFont(new Font("����",Font.BOLD,15));  
        //ʹ��chartFrame������ʾͼ��  
        ChartFrame frame = new ChartFrame("���Է���ͳ��", chart);  
        frame.setVisible(true);  
        frame.pack();  
   }
	
}