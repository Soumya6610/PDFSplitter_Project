package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the PDF file with source path: ");
        String sourcePdf = sc.nextLine();

        File f = new File(sourcePdf);

        PDDocument document = Loader.loadPDF(f);

        Splitter splitter = new Splitter();

        List<PDDocument> splitPages = splitter.split(document);

        int num = 1;
        for (PDDocument doc : splitPages ) {
            doc.save("File_"+num+".pdf");
            num++;
            doc.close();
        }
        System.out.println("Splitting done");
    }
}
