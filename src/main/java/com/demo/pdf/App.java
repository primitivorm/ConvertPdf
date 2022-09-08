package com.demo.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if (args.length == 2) {
    		try {
        		// InputStream docFile = new FileInputStream(new File("C:\\tmp\\PrimitivoRomanCV.docx"));
    			InputStream docFile = new FileInputStream(new File(args[0]));
        		XWPFDocument doc = new XWPFDocument(docFile);
        		PdfOptions pdfOptions = PdfOptions.create();
        		// OutputStream out = new FileOutputStream(new File("C:\\tmp\\PrimitivoRomanCV.pdf"));
        		OutputStream out = new FileOutputStream(new File(args[1]));
        		PdfConverter.getInstance().convert(doc, out, pdfOptions);
        		doc.close();
        		out.close();
        		System.out.println("Done");
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}    		
    	} else {
    		System.out.println("Numero invalido de argumentos");
    	}
    	
    }
}
