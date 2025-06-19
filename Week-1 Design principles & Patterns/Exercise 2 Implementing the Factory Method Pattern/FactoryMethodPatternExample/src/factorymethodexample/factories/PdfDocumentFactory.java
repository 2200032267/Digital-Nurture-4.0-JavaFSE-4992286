package factorymethodexample.factories;

import factorymethodexample.documents.Document;
import factorymethodexample.documents.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}