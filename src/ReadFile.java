

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.RandomAccessFile;  
import java.util.Random;
  
public class ReadFile {  
  
    private String m_fileName = "";  
    private File m_File = null;  
    private BufferedReader m_reader = null;  
  
    public ReadFile(String strFileName) {  
        m_fileName = strFileName;  
        m_File = new File(m_fileName);  
        try {  
            m_reader = new BufferedReader(new FileReader(m_File));  
        } catch (IOException e) {  
  
        }         
    }  
  
    public static boolean writeFile(String strFileName, String content) {  
  
        try {  
  
            RandomAccessFile randomFile = new RandomAccessFile(strFileName,"rw");  
            long fileLength = randomFile.length();  
  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            return false;  
        }  
  
        return true;  
    }  
  
    public String ReadLine() {  
  
        if (!m_File.exists()) {  
            return null;  
        }  
  
        if (m_reader == null) {  
            return null;  
        }  
  
        try {  
            String tempString = m_reader.readLine();  
            return tempString;  
        } catch (IOException e) {  
  
        }  
  
        return "";  
    }  
  
    protected void close() {  
        if (m_reader != null) {  
            try {  
                m_reader.close();  
            } catch (IOException e) {  
            }  
        }  
    }  
  
    /** 
     * @param args 
     */  
    /*public static void main(String[] args) {  
  
    	ReadFile file = new ReadFile("result1.txt");  
        String line = null;  
        
        int i=0;
        while ((line = file.ReadLine()) != null) {  
        	
        	Random random = new Random();

            int s = (int) (Math.random()*1000);
        	    i++;
        	    if(i<=20){
        	    	String[] strs=line.split("=");
        	    	for(int j=0,len=strs.length;j<len-1;j++){
        	    		  System.out.println(strs[j].toString()+'=');//算式无结果
        	    		  //System.out.println(strs[len-1]);结果
        	    		}
        	    	//System.out.println(line);
        	    	
        	    }  
        }  
  
        file.close(); 
        
  
    }  */
  
} 