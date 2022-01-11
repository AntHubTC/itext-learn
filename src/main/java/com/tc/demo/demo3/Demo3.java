package com.tc.demo.demo3;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.tc.util.ITextWriteUtil;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * @author: tangcheng_cd
 * @date: 2022/1/11
 * @description:
 */
public class Demo3 {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        Document document = ITextWriteUtil.getDocument("out/demo3.pdf");

        Image foxImage = new Image(ImageDataFactory.create("in/fox.png"));
        Image dogImage = new Image(ImageDataFactory.create("in/dog.png"));
        Paragraph paragraph = new Paragraph("The quick brown ");
        paragraph.add(foxImage);
        paragraph.add(" jumps over the lazy ");
        paragraph.add(dogImage);

        document.add(paragraph);

        document.close();
    }
}
