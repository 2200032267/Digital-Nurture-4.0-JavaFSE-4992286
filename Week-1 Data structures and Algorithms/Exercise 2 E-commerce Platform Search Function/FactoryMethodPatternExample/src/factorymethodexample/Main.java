package factorymethodexample;

import factorymethodexample.documents.Document;
import factorymethodexample.factories.DocumentFactory;
import factorymethodexample.factories.ExcelDocumentFactory;
import factorymethodexample.factories.PdfDocumentFactory;
import factorymethodexample.factories.WordDocumentFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Factory Method Pattern Test ---");

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        System.out.println("\nClient: I need a Word document.");
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();
        
        System.out.println("\nClient: Now I need a PDF.");
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();  
        pdfDoc.save();  
        
        System.out.println("\nClient: Let's process an Excel file completely.");
        excelFactory.performOperations();
    }
}