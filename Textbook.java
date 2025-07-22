public class Textbook extends Book{
    private String subject;
    private int edition;

    // Constructor that calls parent constructor
    public Textbook(String title, String author, int pages, String subject, int edition) {
        super(title,author,pages);
        this.subject = subject;
        this.edition = edition;
    }

    // Override the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: "+subject);
        System.out.println("Edition: "+edition);
    }

    // Add getter methods for subject and edition
    public int getEdition() {
        return edition;
    }

    public String getSubject() {
        return subject;
    }
}
