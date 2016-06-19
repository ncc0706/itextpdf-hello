package com.xlinyu.examples;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class SetPDFAttributes {

	public static void main(String[] args) {
		
		Document document = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("document/设置pdf属性.pdf"));
			
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", 
					BaseFont.NOT_EMBEDDED); 
			Font chineseFont= new Font(bfChinese, 12, Font.NORMAL);   
			
			document.open();
			document.add(new Paragraph("填写内容.....,....", chineseFont));
			
			document.addAuthor("牛玉贤");
			document.addTitle("itextpdf学习");
			document.addCreationDate();
			document.addSubject("....itextpdf学习");
			
			// 空格隔开
			document.addKeywords("itextpdf java nodejs python");
			document.addCreator("How Todo in Java");
			
			
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
