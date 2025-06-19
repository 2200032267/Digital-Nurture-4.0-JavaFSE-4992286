package factorymethodexample.factories;

import factorymethodexample.documents.Document;
import factorymethodexample.documents.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}