package com.tc.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileNotFoundException;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class ITextWriteUtil {

    public static PdfDocument getPdfDocument(String fileName) throws FileNotFoundException {
        try {
            PdfWriter pdfWriter = new PdfWriter(fileName);
            return new PdfDocument(pdfWriter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 获取Doucment
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    public static Document getDocument(String fileName) throws FileNotFoundException {
        try {
            return new Document(getPdfDocument(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
