package factorymethodexample.factories;

import factorymethodexample.documents.Document;
import factorymethodexample.documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}