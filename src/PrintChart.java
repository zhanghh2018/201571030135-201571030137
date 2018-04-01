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
        //添加数据  
		for(int i=1;i<=SubmissionsNum;i++){
			
			dataset.addValue(Score[i],"分数"+i, "第"+i+"轮"); 
			 
		}
		
        JFreeChart chart = ChartFactory.createBarChart3D("分数统计图", //主标题的名称  
                          								"测试次数", //X轴的标签  
                                                        "测试分数(分数)", //Y轴的标签  
                                                        dataset, //图标显示的数据集合  
                                                        PlotOrientation.VERTICAL,//图像的显示形式（水平或者垂直）   
                                                        true, //是否显示子标题  
                                                        true, //是否生成提示的标签  
                                                        true);//是否生成url链接  
        
        //处理图形上的乱码  
        //处理主标题的乱码  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,18));  
        //处理子标题乱码  
        chart.getLegend().setItemFont(new Font("宋体",Font.BOLD,15));  
        //获取图表区域对象  
        CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();  
        //获取X轴的对象  
        CategoryAxis3D categoryAxis3D = (CategoryAxis3D) categoryPlot.getDomainAxis();  
        //获取Y轴的对象  
        NumberAxis3D numberAxis3D = (NumberAxis3D) categoryPlot.getRangeAxis();  
        //处理X轴上的乱码  
        categoryAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));  
        //处理X轴外的乱码  
        categoryAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));  
        //处理Y轴上的乱码  
        numberAxis3D.setTickLabelFont(new Font("宋体",Font.BOLD,15));  
        //处理Y轴外的乱码  
        numberAxis3D.setLabelFont(new Font("宋体",Font.BOLD,15));  
        //处理Y轴上显示的刻度，以1作为1格  
        numberAxis3D.setAutoTickUnitSelection(false);  
        NumberTickUnit unit = new NumberTickUnit(100);  
        numberAxis3D.setTickUnit(unit);  
        //获取绘图区域对象  
        BarRenderer3D barRenderer3D = (BarRenderer3D) categoryPlot.getRenderer();  
        //设置柱形图的宽度  
        barRenderer3D.setMaximumBarWidth(0.07);  
        //在图形上显示数字  
        barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
        barRenderer3D.setBaseItemLabelsVisible(true);  
        //设置  
        barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1,TextAnchor.CENTER));  
        barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,15));  
        //使用chartFrame对象显示图像  
        ChartFrame frame = new ChartFrame("测试分数统计", chart);  
        frame.setVisible(true);  
        frame.pack();  
   }
	
}