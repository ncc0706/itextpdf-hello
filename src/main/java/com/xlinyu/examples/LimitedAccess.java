package com.xlinyu.examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class LimitedAccess {

	
	public static void main(String[] args) {
	    try {
	        OutputStream file = new FileOutputStream(new File(
	                "document/LimitedAccess.pdf"));
	        Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, file);
	        // 仅允许打印 不允许复制
	        writer.setEncryption("".getBytes(), "".getBytes(),
	                PdfWriter.ALLOW_PRINTING , //Only printing allowed; Try to copy text !!
	                PdfWriter.ENCRYPTION_AES_128);
	 
	        document.open();
	        document.add(new Paragraph("Limited Access File !!"));
	        document.close();
	        file.close();
	 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
