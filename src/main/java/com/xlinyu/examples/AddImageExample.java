package com.xlinyu.examples;

import java.io.FileOutputStream;
import java.net.URL;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class AddImageExample {

	public static void main(String[] args) {
		
		Document document = new Document();
		
		try {
			
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("document/带图片的.pdf"));
			
			document.open();
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", 
					BaseFont.NOT_EMBEDDED); 
			Font chineseFont= new Font(bfChinese, 12, Font.NORMAL); 
			
			document.add(new Paragraph("添加图片", chineseFont));
			
			Image image1 = Image.getInstance("image/2016-06-19_221753.png");
			
			//Fixed Positioning
			//image1.setAbsolutePosition(100f, 550f);
			
			//Scale to new height and new width of image
		    image1.scaleAbsolute(200, 200);
			document.add(image1);
			
			
			String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
		    Image image2 = Image.getInstance(new URL(imageUrl));
		    //image2.setWidthPercentage(20f);
		    
		    //image2.setAbsolutePosition(0, 0);
		    image2.scaleToFit(126, 100);
		    System.out.println(image2.getScaledWidth());
		    System.out.println(image2.getScaledHeight()); 
		    
		    document.add(image2);
			
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
