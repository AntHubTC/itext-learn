package com.tc.demo.demo7;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.tc.util.ITextWriteUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = ITextWriteUtil.getPdfDocument("out/demo7.pdf");
        PageSize ps = PageSize.A6.rotate();
        PdfPage pdfPage = pdfDocument.addNewPage(ps);

        PdfCanvas canvas = new PdfCanvas(pdfPage);


        List<String> txtList = new ArrayList<String>();
        txtList.add("         Episode V         ");
        txtList.add("  THE EMPIRE STRIKES BACK  ");
        txtList.add("It is a dark time for the");
        txtList.add("Rebellion. Although the Death");
        txtList.add("Star has been destroyed,");
        txtList.add("Imperial troops have driven the");
        txtList.add("Rebel forces from their hidden");
        txtList.add("base and pursued them across");
        txtList.add("the galaxy.");
        txtList.add("Evading the dreaded Imperial");
        txtList.add("Starfleet, a group of freedom");
        txtList.add("fighters led by Luke Skywalker");
        txtList.add("has established a new secret");
        txtList.add("base on the remote ice world");
        txtList.add("of Hoth...");

        canvas.concatMatrix(1, 0, 0, 1, 0, ps.getHeight());
        canvas.beginText()
                .setStrokeColor(Color.WHITE)
                .setFontAndSize(PdfFontFactory.createFont(FontConstants.COURIER_BOLD), 14)
                .setLeading(14 * 1.2f)
                .moveText(70, -40);
        for (String txt : txtList) {
            canvas.newlineShowText(txt);
        }
        canvas.endText();

        pdfDocument.close();
    }
}
