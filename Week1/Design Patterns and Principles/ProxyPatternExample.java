
/**
 * Exercise 6: Implementing the Proxy Pattern
 *
 * Scenario:
 * You are developing an image viewer application that loads images from a remote server. Use the Proxy Pattern to add lazy initialization and caching.
 *
 * Steps:
 * 1. Create a New Java Project:
 *    - Create a new Java project named ProxyPatternExample.
 * 2. Define Subject Interface:
 *    - Create an interface Image with a method display().
 * 3. Implement Real Subject Class:
 *    - Create a class RealImage that implements Image and loads an image from a remote server.
 * 4. Implement Proxy Class:
 *    - Create a class ProxyImage that implements Image and holds a reference to RealImage.
 *    - Implement lazy initialization and caching in ProxyImage.
 * 5. Test the Proxy Implementation:
 *    - Create a test class to demonstrate the use of ProxyImage to load and display images.
 */

// Step 2: Define Subject Interface
interface Image {
    void display();
}

// Step 3: Implement Real Subject Class
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename + " from disk...");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Step 4: Implement Proxy Class
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Step 5: Test the Proxy Implementation
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image will be loaded from disk and then displayed
        image1.display();
        System.out.println("");

        // Image will not be loaded from disk again
        image1.display();
        System.out.println("");

        // Image will be loaded from disk and then displayed
        image2.display();
    }
}
/*Expected Output:
Loading photo1.jpg from disk...
Displaying photo1.jpg

Displaying photo1.jpg

Loading photo2.jpg from disk...
Displaying photo2.jpg
 */
