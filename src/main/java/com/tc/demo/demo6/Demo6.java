package com.tc.demo.demo6;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.tc.util.ITextWriteUtil;

import java.io.FileNotFoundException;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo6 {
    public static void main(String[] args) throws FileNotFoundException {
        PdfDocument pdfDocument = ITextWriteUtil.getPdfDocument("out/demo6.pdf");
        PageSize ps = PageSize.A4.rotate();
        PdfPage pdfPage = pdfDocument.addNewPage(ps);

        PdfCanvas canvas = new PdfCanvas(pdfPage);

        canvas.concatMatrix(1, 0, 0, 1, ps.getWidth()/2, ps.getHeight()/2);

        //Draw X axis
        canvas.moveTo(-(ps.getWidth() / 2 - 15), 0)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .stroke();
        //Draw Y axis
        canvas.moveTo(0, -(ps.getHeight() / 2 - 15))
                .lineTo(0, ps.getHeight() / 2 - 15)
                .stroke();

        //Draw X axis arrow
        canvas.setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(ps.getWidth() / 2 - 25, -10)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .lineTo(ps.getWidth() / 2 - 25, 10).stroke()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.MITER);
        //Draw Y axis arrow
        canvas.saveState()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(-10, ps.getHeight() / 2 - 25)
                .lineTo(0, ps.getHeight() / 2 - 15)
                .lineTo(10, ps.getHeight() / 2 - 25).stroke()
                .restoreState();

        //Draw X serif
        for (int i = -((int) ps.getWidth() / 2 - 61);
             i < ((int) ps.getWidth() / 2 - 60); i += 40) {
            canvas.moveTo(i, 5).lineTo(i, -5);
        }
        //Draw Y serif
        for (int j = -((int) ps.getHeight() / 2 - 57);
             j < ((int) ps.getHeight() / 2 - 56); j += 40) {
            canvas.moveTo(5, j).lineTo(-5, j);
        }
        canvas.stroke();

        Color grayColor = new DeviceCmyk(0.f, 0.f, 0.f, 0.875f);
        Color greenColor = new DeviceCmyk(1.f, 0.f, 1.f, 0.176f);
        Color blueColor = new DeviceCmyk(1.f, 0.156f, 0.f, 0.118f);

        canvas.setLineWidth(0.5f).setStrokeColor(blueColor);

        for (int i = -((int) ps.getHeight() / 2 - 57);
             i < ((int) ps.getHeight() / 2 - 56); i += 40) {
            canvas.moveTo(-(ps.getWidth() / 2 - 15), i)
                    .lineTo(ps.getWidth() / 2 - 15, i);
        }
        for (int j = -((int) ps.getWidth() / 2 - 61);
             j < ((int) ps.getWidth() / 2 - 60); j += 40) {
            canvas.moveTo(j, -(ps.getHeight() / 2 - 15))
                    .lineTo(j, ps.getHeight() / 2 - 15);
        }
        canvas.stroke();

        canvas.setLineWidth(3).setStrokeColor(grayColor);

        canvas.setLineWidth(2).setStrokeColor(greenColor)
                .setLineDash(10, 10, 8)
                .moveTo(-(ps.getWidth() / 2 - 15), -(ps.getHeight() / 2 - 15))
                .lineTo(ps.getWidth() / 2 - 15, ps.getHeight() / 2 - 15).stroke();

        pdfDocument.close();
    }
}
