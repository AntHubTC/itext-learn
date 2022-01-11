package com.tc.demo.demo8;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.tc.util.ITextWriteUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo8 {
    public static void main(String[] args) throws IOException {
        PdfDocument pdfDocument = ITextWriteUtil.getPdfDocument("out/demo8.pdf");
        PageSize ps = PageSize.A6.rotate();
        PdfPage pdfPage = pdfDocument.addNewPage(ps);

        PdfCanvas canvas = new PdfCanvas(pdfPage);

        canvas.rectangle(0, 0, ps.getWidth(), ps.getHeight())
                .setColor(Color.BLACK, true)
                .fill();

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

        final int maxStringWidth = 30;

        canvas.concatMatrix(1, 0, 0, 1, 0, ps.getHeight());
        Color yellowColor = new DeviceCmyk(0.f, 0.0537f, 0.769f, 0.051f);
        float lineHeight = 5;
        float yOffset = -40;
        canvas.beginText()
                .setFontAndSize(PdfFontFactory.createFont(FontConstants.COURIER_BOLD), 1)
                .setColor(yellowColor, true);
        for (int j = 0; j < txtList.size(); j++) {
            String line = txtList.get(j);
            float xOffset = ps.getWidth() / 2 - 45 - 8 * j;
            float fontSizeCoeff = 6 + j;
            float lineSpacing = (lineHeight + j) * j / 1.5f;
            int stringWidth = line.length();
            for (int i = 0; i < stringWidth; i++) {
                float angle = (maxStringWidth / 2 - i) / 2f;
                float charXOffset = (4 + (float) j / 2) * i;
                canvas.setTextMatrix(fontSizeCoeff, 0,
                                angle, fontSizeCoeff / 1.5f,
                                xOffset + charXOffset, yOffset - lineSpacing)
                        .showText(String.valueOf(line.charAt(i)));
            }
        }
        canvas.endText();

        pdfDocument.close();
    }
}
