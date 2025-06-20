package factorymethodexample.factories;

import factorymethodexample.documents.Document;

public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void performOperations() {
        Document doc = createDocument(); 
        doc.open();
        doc.save();
        doc.close();
    }
}