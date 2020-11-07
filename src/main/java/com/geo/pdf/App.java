package com.geo.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author geo
 * Java Program to generate PDF document using iText library. 
 */
public class App {

	public static void main(String args[]) {
		OutputStream file = null;
		try {
			file = new FileOutputStream(new File("Contacts.pdf"));
			// Create a new Document object
			Document document = new Document();
			// You need PdfWriter to generate PDF document
			PdfWriter.getInstance(document, file);
			// Opening document for writing PDF
			document.open();
			// Writing content
			document.add(new Paragraph("Hello World, Creating PDF document in Java is easy"));
			document.add(new Paragraph("You are customer # 2345433"));
			document.add(new Paragraph(new Date(new java.util.Date().getTime()).toString()));
			// Add meta data information to PDF file
			document.addCreationDate();
			document.addAuthor("Javarevisited");
			document.addTitle("How to create PDF document in Java");
			document.addCreator("Thanks to iText, writing into PDF is easy");
			// close the document
			document.close();
			System.out.println("Your PDF File is succesfully created");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// closing FileOutputStream
			try {
				if (file != null) {
					file.close();
				}
			} catch (IOException io) {
				/* Failed to close */
			}
		}
	}
}
