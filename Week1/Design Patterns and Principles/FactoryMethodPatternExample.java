
/**
 * Exercise 2: Implementing the Factory Method Pattern
 *
 * Scenario:
 * You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named FactoryMethodPatternExample.
 * 2. Define Document Classes:
 *    - Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
 * 3. Create Concrete Document Classes:
 *    - Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
 * 4. Implement the Factory Method:
 *    - Create an abstract class DocumentFactory with a method createDocument().
 *    - Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
 * 5. Test the Factory Method Implementation:
 *    - Create a test class to demonstrate the creation of different document types using the factory method.
 */

// Step 2: Define Document Interfaces
interface Document {
    void open();
}

// Step 3: Create Concrete Document Classes
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document");
    }
}

// Step 4: Implement the Factory Method
abstract class DocumentFactory {
    abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    Document createDocument() {
        return new ExcelDocument();
    }
}

// Step 5: Test the Factory Method Implementation
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        // Creating Word Document using the Factory Method
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Creating PDF Document using the Factory Method
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Creating Excel Document using the Factory Method
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
/*Expected Output:
Opening Word Document
Opening PDF Document
Opening Excel Document
 */