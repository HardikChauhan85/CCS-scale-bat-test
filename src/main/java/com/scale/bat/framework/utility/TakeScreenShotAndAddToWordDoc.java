package com.scale.bat.framework.utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class TakeScreenShotAndAddToWordDoc {

	static ArrayList<String> allImageDetails=new ArrayList<String>();
	static int imagePath=1;
	static String dirPath = "C:\\Users\\571154\\OneDrive - Cognizant\\Desktop\\Images\\" ;
	static XWPFDocument docx;
	static FileOutputStream out;
	static XWPFRun run;
	static File file;
	static File file1;
	static BufferedImage image;
	static InputStream pic;
	
	public static void main(String[] args) {
        try {
         //String dirPath = "C:\\Users\\571154\\OneDrive - Cognizant\\Desktop\\Images\\" ;
        	
        	createWordFile();
         
         for (int counter = 1; counter <= 5; counter++) {
             captureScreenShotNew();
             TimeUnit.SECONDS.sleep(1);
         }
         
         for(int i=0;i<allImageDetails.size();i++) {
         	
         	System.out.println("Image Name: " + allImageDetails.get(i));
         	
         }
         
                    
            //System.out.println("Write to doc file sucessfully...");
            writeScreenShot();
            writeDoc();
            
          } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public static void captureScreenShotNew() {
		
		imagePath=imagePath-1;
    	String screenshot_name = System.currentTimeMillis() + ".png";
        
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (HeadlessException | AWTException e1) {
			
			e1.printStackTrace();
		}
		
        file = new File(dirPath + screenshot_name);
        try {
			ImageIO.write(image, "png", file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
        allImageDetails.add(dirPath + screenshot_name);
        imagePath++;
	}
	
	public static void writeScreenShot() {
		
		for(int i=0;i<allImageDetails.size();i++) {
        	
        	System.out.println("Image Name Inside: " + allImageDetails.get(i));
        	
        	
			try {
				pic = new FileInputStream(allImageDetails.get(i));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
            run.addBreak();
            try {
				run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, allImageDetails.get(i), Units.toEMU(500), Units.toEMU(350));
			} catch (InvalidFormatException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
            try {
				pic.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
            
            /*String filelocation = allImageDetails.get(i);
            File myFile= new File(filelocation);
            myFile.delete();*/
                  	
        }
		
		
		
	}
	
	
       
    public static void createWordFile() {
	    //Create folder/directory if not exist.
        file1 = new File(dirPath);
           if (!file1.exists()) {
               if (file1.mkdir()) {
                   System.out.println("Directory is created!");
               } else {
                   System.out.println("Failed to create directory!");
               }
           }

            docx = new XWPFDocument();
            run = docx.createParagraph().createRun();
           try {
			out = new FileOutputStream(dirPath+"doc1.docx");
			
			System.out.println("doc1 Word file created !!!");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
    
    public static void writeDoc() throws IOException {
    	
    	System.out.println("Write to doc file sucessfully...");

        docx.write(out);
        out.flush();
        out.close();
        docx.close();
    	
    }


}
