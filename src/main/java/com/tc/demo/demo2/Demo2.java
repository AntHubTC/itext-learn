package com.tc.demo.demo2;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo2 {
    public static void main(String[] args) {
        try {
//            PdfWriter pdfWriter = new PdfWriter(new ByteArrayOutputStream());
            PdfWriter pdfWriter = new PdfWriter("out/demo2.pdf");
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            // 创建字体
            PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
            document.setFont(font);
            // 添加段落
            document.add(new Paragraph("iText is:"));
            // 创建一个列表
            List list = new List()
                    .setFont(font)          // 设置字体
                    .setSymbolIndent(12)    // 列表缩进大小
                    .setListSymbol("\u2022") // 设置列表符号为远点
            ;
            list.add(new ListItem("Never gonna give you up"))
                    .add(new ListItem("Never gonna let you down"))
                    .add(new ListItem("Never gonna run around and desert you"))
                    .add(new ListItem("Never gonna make you cry"))
                    .add(new ListItem("Never gonna say goodbye"))
                    .add(new ListItem("Never gonna tell a lie and hurt you"));
            // 添加列表
            document.add(list);
            document.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
