package com.tc.demo.demo4;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import com.tc.util.ITextWriteUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
//        PdfWriter pdfWriter = new PdfWriter("out/demo4.pdf");
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//        Document document = new Document(pdfDocument, PageSize.A4.rotate());
        Document document = ITextWriteUtil.getDocument("out/demo4.pdf");
        document.getPdfDocument().setDefaultPageSize(PageSize.A4.rotate()); // 设置纸张大小

        // 设置文档边界
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont fontBold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);

        Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1}); // 创建表格，设置列宽度
        table.setWidth(UnitValue.createPercentValue(100)); // 百分比设置表格宽度

        BufferedReader br = new BufferedReader(new FileReader("in/united_states.csv"));
        // 表头
        String line = br.readLine();
        process(table, line, fontBold, true);
        // 表正文
        while ((line = br.readLine()) != null) {
            process(table, line, font, false);
        }
        br.close();

        document.add(table);
        document.close();
    }

    private static void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isHeader) {
                table.addHeaderCell(new Cell().add(
                        new Paragraph(token).setFont(font)));
            } else {
                table.addCell(new Cell().add(
                        new Paragraph(token).setFont(font)));
            }
        }
    }
}
