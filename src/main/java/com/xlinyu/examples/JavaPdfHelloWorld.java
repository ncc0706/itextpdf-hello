package com.xlinyu.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class JavaPdfHelloWorld {

	public static void main(String[] args) {
		
		Document document = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, 
					new FileOutputStream("document/helloworld.pdf"));
			document.open();
			document.add(new Paragraph("A Hello World PDF Document ."));
			document.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
