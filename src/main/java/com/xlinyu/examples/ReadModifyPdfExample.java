package com.xlinyu.examples;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReadModifyPdfExample {

	
	public static void main(String[] args) {
		
		try {
		    //Read file using PdfReader
			PdfReader pdfReader = new PdfReader("document/HelloWorld.pdf");
		 
		    //Modify file using PdfReader
		    PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("document/HelloWorld-modified.pdf"));
		    
		    for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
		        /*PdfContentByte content = pdfStamper.getUnderContent(i);
		        content.getInternalBuffer().append("add content");
		        System.out.println("..........." + content.toString());*/
		    	
		    	PdfContentByte overContent = pdfStamper.getOverContent(i);
		    	//添加文字
		    	BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); 
		    	overContent.beginText();
		    	overContent.setFontAndSize(bfChinese, 12);
		    	//overContent.setTextMatrix(200, 200);
		    	//overContent.showTextAligned(Element.ALIGN_CENTER, "此处是添加的内容",100,400,0);
		    	overContent.showText("晚安。。。。");
		    	overContent.endText();
		    }
		    pdfStamper.close();
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		
		}
	
}
