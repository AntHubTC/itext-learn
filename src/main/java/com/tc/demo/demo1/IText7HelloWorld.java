package com.tc.demo.demo1;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description: hello world
 */
public class IText7HelloWorld {
    public static void main(String[] args) {
        try {
            PdfWriter pdfWriter = new PdfWriter("out/demo1.pdf");
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            document.add(new Paragraph("Hello world!"));

            document.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
